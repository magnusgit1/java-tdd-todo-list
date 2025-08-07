






1. Add tasks to my todo list.

| Classes    | Methods                        | Scenario                   | Outputs |
|------------|--------------------------------|----------------------------|---------|
| `TodoList` | `boolean addTask(String task)` | If task is null or invalid | false   |
|            |                                | If task is provided        | true    |


2. See all the tasks in my todo list.


| Classes    | Methods                    | Scenario             | Outputs    |
|------------|----------------------------|----------------------|------------|
| `TodoList` | `List<Task> seeTodoList()` | If list is empty     | null       |
|            |                            | If list is not empty | List<Task> |


3. Change the status of a task between incomplete and complete.

| Classes    | Methods                                      | Scenario                     | Outputs |
|------------|----------------------------------------------|------------------------------|---------|
| `TodoList` | `Task setStatus(String task, String status)` | If status or task is invalid | null    |
|            |                                              | If status and task is valid  | Task    |


4. Get only the complete tasks.


| Classes    | Methods                         | Scenario                     | Outputs    |
|------------|---------------------------------|------------------------------|------------|
| `TodoList` | `List<Task> getCompleteTasks()` | If no tasks are complete     | null       |
|            |                                 | If there are completed tasks | List<Task> |


5. Get only the incomplete tasks.


| Classes    | Methods                           | Scenario                      | Outputs    |
|------------|-----------------------------------|-------------------------------|------------|
| `TodoList` | `List<Task> getIncompleteTasks()` | If no tasks are incomplete    | null       |
|            |                                   | If there are incomplete tasks | List<Task> |


6. Search for a task and receive a message that says it wasn't found if it doesn't exist.


| Classes    | Methods                           | Scenario              | Outputs                                   |
|------------|-----------------------------------|-----------------------|-------------------------------------------|
| `TodoList` | `Task searchForTask(String task)` | If task doesn't exist | print "not found" message and return null |
|            |                                   | If task exists        | return task                               |


7. Remove tasks from my list.


| Classes    | Methods                           | Scenario              | Outputs                |
|------------|-----------------------------------|-----------------------|------------------------|
| `TodoList` | `boolean removeTask(String task)` | If task doesn't exist | false                  |
|            |                                   | If task does exist    | remove and return true |


8. See all the tasks in my list ordered alphabetically in ascending order.


| Classes    | Methods                                               | Scenario                  | Outputs    |
|------------|-------------------------------------------------------|---------------------------|------------|
| `TodoList` | `List<Task> seeTasksInAscendingAndAlpabeticalOrder()` | If list of tasks is empty | null       |
|            |                                                       | If list is not empty      | List<Task> |


9. See all the tasks in my list ordered alphabetically in descending order.


| Classes    | Methods                                                 | Scenario                  | Outputs    |
|------------|---------------------------------------------------------|---------------------------|------------|
| `TodoList` | `List<Task> seeTasksInDescendingAndAlphabeticalOrder()` | If list of tasks is empty | null       |
|            |                                                         | If list is not empty      | List<Task> |