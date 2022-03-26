package com.digiwin.testapp.task;

/**
 * FileName:RequestTask
 * Author: shenbao
 * Date: 2022/3/26 12:49
 * Description:
 */
public class Task implements ITask {
    private TaskCallback callback;
    private String parameter;

    public Task(String parameter, TaskCallback callback) {
        this.callback = callback;
        this.parameter = parameter;
    }

    @Override
    public void execute() {
        System.out.println("task execute:" + parameter);
        if (callback != null) {
            callback.callBack(" result " + parameter + ";");
        }
    }
}
