package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
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
    private static final String DESCRIPTION = "Example description";
    private static final String LISTNAME = "ToDo List";

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