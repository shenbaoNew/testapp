package com.digiwin.testapp.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * FileName:AppCommonUtils
 * Author: shenbao
 * Date: 2021/12/22 22:29
 * Description:
 */
public class AppCommonUtils {
    public static Properties loadProperties(String fileName) {
        Resource resource = new ClassPathResource(fileName);
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
