package com.digiwin.testapp.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * FileName:Parameter
 * Author: shenbao
 * Date: 2021/12/22 11:42
 * Description:
 */
public class Parameter implements RowMapper<Parameter> {
    private String tenantsid;
    private String detectTime;
    private String planNo;
    private String planName;

    public String getTenantsid() {
        return tenantsid;
    }

    public void setTenantsid(String tenantsid) {
        this.tenantsid = tenantsid;
    }

    public String getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(String detectTime) {
        this.detectTime = detectTime;
    }

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Override
    public Parameter mapRow(ResultSet rs, int rowNum) throws SQLException {
        this.tenantsid=rs.getString("tenantsid");
        this.detectTime = rs.getString("detect_time");
        this.planNo = rs.getString("plan_no");
        this.planName = rs.getString("plan_name");
        return this;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "planNo='" + planNo + '\'' +
                ", planName='" + planName + '\'' +
                '}';
    }
}
