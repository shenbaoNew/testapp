package com.digiwin.testapp.controller;

import com.digiwin.testapp.model.Parameter;
import com.digiwin.testapp.service.IParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * FileName:ParameterController
 * Author: shenbao
 * Date: 2021/12/22 13:32
 * Description:
 */
@RestController
@RequestMapping("/parameter")
public class ParameterController {
    @Qualifier("parameter")
    @Autowired
    IParameterService parameterService;

    @RequestMapping("/all")
    public List<Parameter> getAllParameter(){
        return parameterService.getAllParameter();
    }

    @RequestMapping("/all2")
    public List<Map<String,Object>> getAllParameter2(){
        return parameterService.getAllParameter2();
    }
}
