package com.digiwin.testapp.service;

import com.digiwin.testapp.model.Parameter;

import java.util.List;
import java.util.Map;

/**
 * FileName:IDeliveryService
 * Author: shenbao
 * Date: 2021/12/22 11:41
 * Description:
 */
public interface IParameterService {
    public List<Parameter> getAllParameter();

    public List<Map<String, Object>> getAllParameter2();
}
