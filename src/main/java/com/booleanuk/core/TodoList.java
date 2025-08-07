package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    List<Task> todoList;

    public TodoList(){
        this.todoList = new ArrayList<>();
    }

    private static class Task {
        String task;
        String status;

        public Task(String task, String status){
            this.task = task;
            this.status = status;
        }
    }

    public boolean addTask(String task){
        if (task.isEmpty()){
            return false;
        } else if (!task.matches("[a-zA-Z]+")){
            return false;
        }
        else {
            todoList.add(new Task(task, "incomplete"));
            return true;
        }
    }
}
