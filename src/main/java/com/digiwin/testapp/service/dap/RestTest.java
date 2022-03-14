package com.digiwin.testapp.service.dap;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.methods.HttpPost;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * FileName:RestTest
 * Author: shenbao
 * Date: 2022/2/20 20:38
 * Description:
 */
public class RestTest {
    public void test() {
        RestTemplate restTemplate = new RestTemplate();
        String json = "{\n" +
                "  \"std_data\": {\n" +
                "    \"parameter\": {\n" +
                "      \"query_condition\": [\n" +
                "        {\n" +
                "          \"responsible_person_no\": \"pur004\",\n" +
                "          \"executor_no\": \"pur001\",\n" +
                "          \"data_status\": \"0\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"enterprise_no\": \"1\",\n" +
                "      \"site_no\": \"1\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Map<String, Object> body = new Gson().fromJson(json, Map.class);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("digi-type", "sync");
        httpHeaders.add("digi-service", "{\"prod\":\"MKP\",\"tenant_id\":\"E10ATHENA\",\"name\":\"supplier.delivery.plan.daily.info.get\",\"uid\":\"MKP\"}");
        httpHeaders.add("digi-key", "6f63960bf7ea10aed76414138274339d");
        httpHeaders.add("digi-host", "{\"prod\":\"Athena\",\"ver\":\"1.0\",\"ip\":\"\",\"id\":\"AgileInteraction\",\"timestamp\":\"20220220133016673\",\"lang\":\"zh_TW\",\"eoc_acct\":\"athena\",\"acct\":\"athena\"}");
        httpHeaders.add("digi-eocmap", "{\"eoc_company_id\":\"1\",\"eoc_region_id\":\"\",\"eoc_site_id\":\"1\"}");
        httpHeaders.add("token", "40a61160-ad67-4336-8240-56aea08b6e97");
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<Map> mapResponseEntity = restTemplate.postForEntity("https://esp-test.apps.digiwincloud.com.cn/CROSS/RESTful",
                entity, Map.class);
        System.out.println(mapResponseEntity);
    }
}
