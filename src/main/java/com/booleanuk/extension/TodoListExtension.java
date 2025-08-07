package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoListExtension {
    List<TaskExt> todoList;

    public TodoListExtension() {
        this.todoList = new ArrayList<>();
    }

    public static class TaskExt {
        String task;
        String status;
        int id;
        LocalDateTime timeCreated;

        public TaskExt(String task, int id) {
            this.task = task;
            this.status = "incomplete";
            this.id = id;
            this.timeCreated = LocalDateTime.now();
        }
    }

    public void addTaskExt(String task, int id){
        todoList.add(new TaskExt(task, id));
    }

    public TaskExt getTaskByUniqueId(int id){
        List<TaskExt> res = todoList.stream().filter(it -> it.id == id).toList();
        return res.isEmpty() ? null : res.getFirst();
    }

    public TaskExt updateNameBasedOnId(int id, String task){
        List<TaskExt> targets = todoList.stream().filter(it -> it.id == id).toList();
        TaskExt updatedTask = new TaskExt(task, id);
        if (targets.isEmpty())
            return null;
        else {
            this.todoList.set(todoList.indexOf(targets.getFirst()), updatedTask);
            return updatedTask;
        }
    }

    public TaskExt updateStatusBasedOnId(int id, String newStatus) {
        List<TaskExt> targets = todoList.stream().filter(it -> it.id == id).toList();
        TaskExt updatedTask = new TaskExt(targets.getFirst().task, id);
        updatedTask.status = newStatus;
        if (targets.isEmpty())
            return null;
        else {
            this.todoList.set(todoList.indexOf(targets.getFirst()), updatedTask);
            return updatedTask;
        }
    }

    public LocalDateTime whenTaskCreated(int id) {
        List<TaskExt> targets = todoList.stream().filter(it -> it.id == id).toList();
        return targets.isEmpty() ? null : targets.getFirst().timeCreated;
    }
}
