package com.digiwin.testapp.config;

import com.digiwin.testapp.config.condition.DbEnableCondition;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

/**
 * FileName:AppDbAutoConfiguration
 * Author: shenbao
 * Date: 2021/12/22 15:47
 * Description:
 */
@Configuration
public class AppDbAutoConfiguration {
    @Autowired
    private Environment environment;

    public AppDbAutoConfiguration() {
    }

    @Bean(name = {"app-dataSource"}, destroyMethod = "")
    @Conditional({DbEnableCondition.class})
    public BasicDataSource basicDataSource() {
        //应用程序关闭时 BasicDataSource 自动关闭
        //Spring使用默认的destroy方法关闭DataSource但它已经关闭
        //否则关闭时会报一个警告
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setInitialSize(Integer.valueOf(environment.getProperty("spring.datasource.dbcp2.initial-size")));
        dataSource.setMinIdle(Integer.valueOf(environment.getProperty("spring.datasource.dbcp2.min-idle")));
        dataSource.setMaxTotal(Integer.valueOf(environment.getProperty("spring.datasource.dbcp2.max-total")));
        dataSource.setMaxWaitMillis(Integer.valueOf(environment.getProperty("spring.datasource.dbcp2.max-wait-millis")));

        return dataSource;
    }

    @Bean(name = {"app-proxyDataSource"})
    @Conditional({DbEnableCondition.class})
    public TransactionAwareDataSourceProxy transactionAwareDataSourceProxy(@Qualifier("app-dataSource") BasicDataSource basicDataSource) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(basicDataSource);
        return proxy;
    }

    @Bean(name = {"app-queryRunner"})
    @Conditional({DbEnableCondition.class})
    public QueryRunner queryRunner(@Qualifier("app-proxyDataSource") TransactionAwareDataSourceProxy transactionAwareDataSourceProxy) {
        QueryRunner runner = new QueryRunner(transactionAwareDataSourceProxy);
        return runner;
    }

    @Bean(name = {"app-transactionManager"})
    @Conditional({DbEnableCondition.class})
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("app-proxyDataSource") TransactionAwareDataSourceProxy transactionAwareDataSourceProxy) {
        DataSourceTransactionManager sourceTransactionManager = new DataSourceTransactionManager();
        sourceTransactionManager.setDataSource(transactionAwareDataSourceProxy);
        return sourceTransactionManager;
    }

    @Bean(name = {"app-jdbcTemplate"})
    @Conditional({DbEnableCondition.class})
    public JdbcTemplate jdbcTemplate(@Qualifier("app-proxyDataSource") DataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template;
    }
}
