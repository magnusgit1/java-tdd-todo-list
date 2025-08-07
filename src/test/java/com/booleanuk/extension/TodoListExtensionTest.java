package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TodoListExtensionTest {

    @Test
    public void testGetTaskByUniqueId() {

        TodoListExtension todoList = new TodoListExtension();

        TodoListExtension.TaskExt task1 = new TodoListExtension.TaskExt("running", 5);
        TodoListExtension.TaskExt task2 = new TodoListExtension.TaskExt("shopping", 3);

        todoList.addTaskExt(task1.task, task1.id);
        todoList.addTaskExt(task2.task, task2.id);

        Assertions.assertEquals("running", todoList.getTaskByUniqueId(5).task);
        Assertions.assertEquals("shopping", todoList.getTaskByUniqueId(3).task);
    }

    @Test
    public void testUpdateNameBasedOnId() {

        TodoListExtension todoList = new TodoListExtension();

        TodoListExtension.TaskExt task1 = new TodoListExtension.TaskExt("running", 5);
        TodoListExtension.TaskExt task2 = new TodoListExtension.TaskExt("shopping", 3);

        todoList.addTaskExt(task1.task, task1.id);
        todoList.addTaskExt(task2.task, task2.id);

        String newName = "work";

        Assertions.assertEquals(newName, todoList.updateNameBasedOnId(5, newName).task);
    }


    @Test
    public void testUpdateStatusBasedOnId() {

        TodoListExtension todoList = new TodoListExtension();

        TodoListExtension.TaskExt task1 = new TodoListExtension.TaskExt("running", 5);
        TodoListExtension.TaskExt task2 = new TodoListExtension.TaskExt("shopping", 3);

        todoList.addTaskExt(task1.task, task1.id);
        todoList.addTaskExt(task2.task, task2.id);

        String newStatus = "complete";

        Assertions.assertEquals(newStatus, todoList.updateStatusBasedOnId(5, newStatus).status);
    }


    @Test
    public void testWhenTaskCreated() {

        TodoListExtension todoList = new TodoListExtension();

        TodoListExtension.TaskExt task1 = new TodoListExtension.TaskExt("running", 5);
        TodoListExtension.TaskExt task2 = new TodoListExtension.TaskExt("shopping", 3);

        LocalDateTime currentDateTime = LocalDateTime.now();
        todoList.addTaskExt(task1.task, task1.id);
        todoList.addTaskExt(task2.task, task2.id);

        Assertions.assertEquals(currentDateTime, todoList.whenTaskCreated(5));
    }
}

