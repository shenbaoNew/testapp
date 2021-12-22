package com.digiwin.testapp.service.impl;

import com.digiwin.testapp.model.Parameter;
import com.digiwin.testapp.service.IParameterService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * FileName:ParameterService
 * Author: shenbao
 * Date: 2021/12/22 11:42
 * Description:
 */
@Service("parameter")
public class ParameterService implements IParameterService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired(required = false)
    private QueryRunner queryRunner;

    @Override
    public List<Parameter> getAllParameter() {
        String sql = "select tenantsid,detect_time,plan_no,plan_name from mkp_plan_parameter ";
        List<Parameter> parameters = jdbcTemplate.query(sql, new Parameter());
        return parameters;
    }

    public List<Map<String, Object>> getAllParameter2() {
        String sql = "select tenantsid,detect_time,plan_no,plan_name from mkp_plan_parameter ";
        List<Map<String, Object>> parameters = null;
        try {
            parameters = queryRunner.query(sql, new MapListHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parameters;
    }
}
