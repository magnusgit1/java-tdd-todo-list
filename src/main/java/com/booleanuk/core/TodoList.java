package com.booleanuk.core;

import javax.swing.*;
import java.util.ArrayList;
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
        if (task.isEmpty() || !task.matches("[a-zA-Z]+"))
            return false;
        else {
            todoList.add(new Task(task, "incomplete"));
            return true;
        }
    }

    public List<Task> seeTodoList(){
        return (todoList.isEmpty()) ? null : todoList;
    }

    public Task setStatus(String task, String status){

        List<Task> targets = todoList.stream().filter(it -> it.task.equals(task)).toList();
        Task updatedTask = new Task(task, status);
        if (targets.isEmpty())
            return null;
        else {
            this.todoList.set(todoList.indexOf(targets.getFirst()), updatedTask);
            return updatedTask;
        }
    }

    public List<Task> getCompleteTasks() {
        List<Task> completedTasks = todoList.stream().filter(it -> it.status.equals("complete")).toList();
        return completedTasks.isEmpty() ? null : completedTasks;
    }

    public List<Task> getIncompleteTasks() {
        List<Task> completedTasks = todoList.stream().filter(it -> it.status.equals("incomplete")).toList();
        return completedTasks.isEmpty() ? null : completedTasks;
    }

    public Task searchForTask(String task) {
        List<Task> targets = todoList.stream().filter(it -> it.task.equals(task)).toList();
        return (targets.isEmpty()) ? null : targets.getFirst();
    }

    public boolean removeTask(String task) {
        List<Task> targets = todoList.stream().filter(it -> it.task.equals(task)).toList();
        if (targets.isEmpty())
            return false;
        else {
            todoList.remove(targets.getFirst());
            return true;
        }
    }

    public List<Task> seeTasksInAscendingAndAlphabeticalOrder() {
        List<Task> res = new ArrayList<>(todoList);
        res.sort(Comparator.comparing(s -> s.task));
        return res.isEmpty() ? null : res;
    }

    public List<Task> seeTasksInDescendingAndAlphabeticalOrder() {
        List<Task> res = new ArrayList<>(todoList);
        res.sort((s1, s2) -> s2.task.compareTo(s1.task));
        return res.isEmpty() ? null : res;
    }
}
