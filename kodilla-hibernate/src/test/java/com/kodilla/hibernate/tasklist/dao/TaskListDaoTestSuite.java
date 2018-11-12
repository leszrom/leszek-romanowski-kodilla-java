package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    @Autowired
    private TaskDao taskDao;

    private static final String DESCRIPTION = "Example description";
    private static final String LISTNAME = "ToDo List";

    @Test
    public void testNamedQueries() {
        //Given
        Task hibernateTask = new Task("Test: Study Hibernate", 3);
        Task namedQueriesTask = new Task("Test: Practice Named Queries", 6);
        Task nativeQueriesTask = new Task("Test: Study Native Queries", 7);
        Task testsTask = new Task("Test: Makes some tests", 13);

        TaskFinancialDetails tfdHibernate = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tfdNamedQueries = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tfdNativeQueries = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfdTests = new TaskFinancialDetails(new BigDecimal(15), false);

        hibernateTask.setTaskFinancialDetails(tfdHibernate);
        namedQueriesTask.setTaskFinancialDetails(tfdNamedQueries);
        nativeQueriesTask.setTaskFinancialDetails(tfdNativeQueries);
        testsTask.setTaskFinancialDetails(tfdTests);

        TaskList todoList = new TaskList(LISTNAME, DESCRIPTION);
        todoList.getTasks().add(hibernateTask);
        todoList.getTasks().add(namedQueriesTask);
        todoList.getTasks().add(nativeQueriesTask);
        todoList.getTasks().add(testsTask);

        hibernateTask.setTaskList(todoList);
        namedQueriesTask.setTaskList(todoList);
        nativeQueriesTask.setTaskList(todoList);
        testsTask.setTaskList(todoList);

        taskListDao.save(todoList);
        int id = todoList.getId();

        //When
        List<Task> longTasks = taskDao.retrieveLongTasks();
        List<Task> shortTasks = taskDao.retrieveShortTasks();
        List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        List<Task> durationLongerThanTasks = taskDao.retrieveTasksWithDurationLongerThan(6);


        //Then
        try {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2, durationLongerThanTasks.size());
        } finally {
            //CleanUp
            taskListDao.delete(id);
        }
    }

    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task learnHibernate = new Task("Test: Learn Hibernate", 14);
        Task writeEntities = new Task("Test: Write some entities", 4);

        TaskFinancialDetails tfdHibernate = new TaskFinancialDetails(new BigDecimal(30), false);
        TaskFinancialDetails tfdEntities = new TaskFinancialDetails(new BigDecimal(50), false);

        learnHibernate.setTaskFinancialDetails(tfdHibernate);
        writeEntities.setTaskFinancialDetails(tfdEntities);

        TaskList toDoList = new TaskList(LISTNAME, "ToDo tasks on ToDo List");
        toDoList.getTasks().add(learnHibernate);
        toDoList.getTasks().add(writeEntities);

        learnHibernate.setTaskList(toDoList);
        writeEntities.setTaskList(toDoList);

        //When
        taskListDao.save(toDoList);
        int id = toDoList.getId();
        List<Task> readTasks = taskListDao.findOne(id).getTasks();

        //Then
        Assert.assertNotEquals(0, id);
        Assert.assertEquals(2, readTasks.size());

        //CleanUp
        taskListDao.delete(id);
    }

    @Test
    public void testFindByListName() {
        //Given
        TaskList doneList = new TaskList("Done List", DESCRIPTION);
        taskListDao.save(doneList);
        String listName = doneList.getListName();

        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(listName);

        //Then
        Assert.assertEquals(1, readTaskLists.size());

        //CleanUp
        int id = readTaskLists.get(0).getId();
        taskListDao.delete(id);
    }
}