package com.booleanuk.core;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TodoList {
    List<Task> todoList;

    public TodoList(){
        this.todoList = new ArrayList<>();
    }

    public static class Task {
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

    public List<Task> seeTodoList(){
        if (todoList.isEmpty()){
            return null;
        } else {
            return todoList;
        }
    }

    public Task setStatus(String task, String status){
        Task rep = null;
        for (Task res : todoList){
            if (res.task.equals(task)){
                rep = res;
            }
        }
        if (seeTodoList() == null){
            return null;
        }
        else if (rep == null){
            return null;
        } else {
            Task updatedTask = new Task(task, status);
            this.todoList.set(todoList.indexOf(rep), updatedTask);
            return updatedTask;
        }
    }

    public List<Task> getCompleteTasks() {
        if (todoList.isEmpty()){
            return null;
        } else {
            List<Task> completedTasks = new ArrayList<>();
            for (Task task : todoList) {
                if (task.status.equals("complete")) {
                    completedTasks.add(task);
                }
            }
            if (completedTasks.isEmpty()){
                return null;
            } else {
                return completedTasks;
            }
        }
    }

    public List<Task> getIncompleteTasks() {
        if (todoList.isEmpty()){
            return null;
        } else {
            List<Task> incompleteTasks = new ArrayList<>();
            for (Task task : todoList) {
                if (task.status.equals("incomplete")) {
                    incompleteTasks.add(task);
                }
            }
            if (incompleteTasks.isEmpty()){
                return null;
            } else {
                return incompleteTasks;
            }
        }
    }

    public Task searchForTask(String task) {
        Task res = null;
        for (Task target : todoList) {
            if (target.task.equals(task)) {
                res = target;
            }
        }
        if (res == null) {
            System.out.println("Not found!");
            return null;
        } else {
            return res;
        }
    }

    public boolean removeTask(String task) {
        Task res = null;
        for (Task target : todoList) {
           if (target.task.equals(task)) {
               res = target;
           }
        }
        if (res == null) {
            return false;
        } else {
            this.todoList.remove(res);
            return true;
        }
    }

    public List<Task> seeTasksInAscendingAndAlphabeticalOrder() {
        if (todoList.isEmpty()) {
            return null;
        }
        List<Task> res = new ArrayList<>(todoList);
        res.sort(Comparator.comparing(s -> s.task));
        return res;
    }

    public List<Task> seeTasksInDescendingAndAlphabeticalOrder() {
        if (todoList.isEmpty()) {
            return null;
        }
        List<Task> res = new ArrayList<>(todoList);
        res.sort(Comparator.comparing(s -> s.task));
        res.sort((s1, s2) -> s2.task.compareTo(s1.task));
        return res;
    }
}
