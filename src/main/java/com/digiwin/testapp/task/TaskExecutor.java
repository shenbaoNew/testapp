package com.digiwin.testapp.task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;

/**
 * FileName:TaskExecutor
 * Author: shenbao
 * Date: 2022/3/26 13:03
 * Description:
 */
public class TaskExecutor {
    private Queue<Task> tasks;
    private static final Object syncObject = new Object();
    private static TaskExecutor taskExecutor;

    private TaskExecutor() {
        this.tasks = new LinkedList<>();
    }

    public static TaskExecutor instance() {
        if (taskExecutor == null) {
            synchronized (syncObject) {
                if (taskExecutor == null) {
                    taskExecutor = new TaskExecutor();
                }
            }
        }
        return taskExecutor;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void execute() {
        Task task;
        while ((task = tasks.poll()) != null) {
            Task finalTask = task;
            Executors.newSingleThreadExecutor().submit(() -> {
                finalTask.execute();
            });
        }
    }

    public static void main(String[] args) {
        TaskExecutor taskExecutor = TaskExecutor.instance();
        Task task = new Task("111", (p) -> System.out.println(" task callback result : " + p + ";"));
        taskExecutor.addTask(task);
        task = new Task("222", (p) -> System.out.println(" task callback result : " + p + ";"));
        taskExecutor.addTask(task);

        taskExecutor.execute();
    }
}
