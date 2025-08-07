package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoListTest {

    @Test
    public void testAddTasksValidInput() {
        TodoList todoList = new TodoList();

        String task1 = "running";
        String task2 = "clean";

        boolean res1 = todoList.addTask(task1);
        boolean res2 = todoList.addTask(task2);

        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
    }

    @Test
    public void testAddTasksInvalidInput() {
        TodoList todoList = new TodoList();

        String task1 = "/clean!";
        String task2 = "";
        String task3 = "1111";

        boolean res1 = todoList.addTask(task1);
        boolean res2 = todoList.addTask(task2);
        boolean res3 = todoList.addTask(task3);

        Assertions.assertFalse(res1);
        Assertions.assertFalse(res2);
        Assertions.assertFalse(res3);
    }
}
