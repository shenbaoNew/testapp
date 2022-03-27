package com.digiwin.testapp.task;

import com.digiwin.testapp.service.dap.RestTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * FileName:Timer
 * Author: shenbao
 * Date: 2022/3/27 23:28
 * Description:
 */
public class TimerDemo {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(simpleDateFormat.format(new Date()) + " ok...");
                RestTest.test();
            }
        }, 1000, 3000);
    }
}
