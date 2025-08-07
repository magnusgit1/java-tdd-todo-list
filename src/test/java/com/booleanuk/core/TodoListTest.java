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

    @Test
    public void testSeeTodoList() {
        TodoList todoList1 = new TodoList();
        TodoList todoList2 = new TodoList();

        String task1 = "running";
        String task2 = "clean";

        todoList1.addTask(task1);
        todoList1.addTask(task2);

        Assertions.assertNull(todoList2.seeTodoList());
        Assertions.assertEquals(2, todoList1.seeTodoList().size());
    }

    @Test
    public void testSetStatus() {
        TodoList todoList = new TodoList();
        TodoList todoList2 = new TodoList();

        String task1 = "running";

        todoList.addTask(task1);
        TodoList.Task task = todoList.setStatus(task1, "complete");

        Assertions.assertEquals("complete", task.status);
        Assertions.assertNull(todoList2.setStatus(task1, "complete"));
    }

    @Test
    public void testGetCompleteTasks() {
        TodoList todoList = new TodoList();
        TodoList todoList2 = new TodoList();

        String task1 = "running";
        String task2 = "cleaning";
        String task3 = "shopping";

        todoList.addTask(task1);
        todoList.addTask(task2);
        todoList.addTask(task3);

        todoList2.addTask(task1);
        todoList2.addTask(task2);
        todoList2.addTask(task3);

        todoList.setStatus(task1, "complete");
        todoList.setStatus(task2, "complete");

        Assertions.assertNull(todoList2.getCompleteTasks());
        Assertions.assertEquals(2, todoList.getCompleteTasks().size());
    }

    @Test
    public void testGetIncompleteTasks() {
        TodoList todoList = new TodoList();

        String task1 = "running";
        String task2 = "cleaning";
        String task3 = "shopping";

        todoList.addTask(task1);
        todoList.addTask(task2);
        todoList.addTask(task3);

        Assertions.assertEquals(3, todoList.getIncompleteTasks().size());

        todoList.setStatus(task1, "complete");
        todoList.setStatus(task2, "complete");
        todoList.setStatus(task3, "complete");

        Assertions.assertNull(todoList.getIncompleteTasks());
    }

    @Test
    public void testSearchForTask() {
        TodoList todoList = new TodoList();

        String task1 = "running";
        String task2 = "cleaning";
        String task3 = "shopping";
        String task4 = "something";

        todoList.addTask(task1);
        todoList.addTask(task2);
        todoList.addTask(task3);

        TodoList.Task res = todoList.searchForTask(task1);

        Assertions.assertEquals("running", res.task);
        Assertions.assertEquals("incomplete", res.status);
        Assertions.assertNull(todoList.searchForTask(task4));
    }

    @Test
    public void testRemoveTask() {
        TodoList todoList = new TodoList();

        String task1 = "running";
        String task2 = "shopping";

        Assertions.assertFalse(todoList.removeTask(task1));

        todoList.addTask(task1);
        todoList.addTask(task2);

        Assertions.assertTrue(todoList.removeTask(task1));
        Assertions.assertTrue(todoList.removeTask(task2));
        Assertions.assertTrue(todoList.todoList.isEmpty());
    }

    @Test
    public void testSeeTasksInAscendingAndAlphabeticalOrder() {

        TodoList todoList = new TodoList();

        String task1 = "running";
        String task2 = "cleaning";
        String task3 = "shopping";
        String task4 = "anything";

        Assertions.assertNull(todoList.seeTasksInAscendingAndAlphabeticalOrder());

        todoList.addTask(task1);
        todoList.addTask(task2);
        todoList.addTask(task3);
        todoList.addTask(task4);

        // Check if the list is unsorted
        Assertions.assertEquals(task1, todoList.todoList.getFirst().task);

        // Then check if the return-value of the method is correctly sorted
        Assertions.assertEquals(task4, todoList.seeTasksInAscendingAndAlphabeticalOrder().getFirst().task);

        // Then make sure the original list is unchanged
        Assertions.assertEquals(task1, todoList.todoList.getFirst().task);
    }

    @Test
    public void testSeeTasksInDescendingAndAlphabeticalOrder() {

        TodoList todoList = new TodoList();

        String task1 = "running";
        String task2 = "cleaning";
        String task3 = "shopping";
        String task4 = "anything";

        Assertions.assertNull(todoList.seeTasksInDescendingAndAlphabeticalOrder());

        todoList.addTask(task1);
        todoList.addTask(task2);
        todoList.addTask(task3);
        todoList.addTask(task4);

        // Check if the list is unsorted
        Assertions.assertEquals(task1, todoList.todoList.getFirst().task);

        // Then check if the return-value of the method is correctly sorted
        Assertions.assertEquals(task3, todoList.seeTasksInDescendingAndAlphabeticalOrder().getFirst().task);

        // Then make sure the original list is unchanged
        Assertions.assertEquals(task1, todoList.todoList.getFirst().task);
    }
}
