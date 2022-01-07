package com.digiwin.testapp.config.condition;

import com.digiwin.testapp.appconst.AppConsts;
import com.digiwin.testapp.utils.AppCommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Properties;

/**
 * FileName:DbEnableCondition
 * Author: shenbao
 * Date: 2021/12/22 22:40
 * Description:
 */
public class DbEnableCondition implements Condition {
    public DbEnableCondition() {
    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Properties environment = AppCommonUtils.loadProperties(AppConsts.APPLICATION_PROPERTIES);
        return environment.getProperty("dbEnabled").equals("true");
    }
}
