package com.digiwin.testapp.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * FileName:MyHealthIndicator
 * Author: shenbao
 * Date: 2021/12/22 14:28
 * Description:
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("error code", errorCode).build();
        } else {
            return Health.up().build();
        }
    }

    private int check() {
        //do something
        return 1;
    }
}
