package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BoardTestSuite {
    @Test
    public void should_return_added_tasks_from_each_list_from_board() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.getToDoList().getTasks().add("First task in ToDoList");
        board.getInProgressList().getTasks().add("First task in InProgressList");
        board.getDoneList().getTasks().add("First task in DoneList");

        String taskFromToDoList = board.getToDoList().getTasks().get(0);
        String taskFromInProgressList = board.getInProgressList().getTasks().get(0);
        String taskFromDoneList = board.getDoneList().getTasks().get(0);
        //Then
        Assert.assertEquals("First task in ToDoList", taskFromToDoList);
        Assert.assertEquals("First task in InProgressList",taskFromInProgressList);
        Assert.assertEquals("First task in DoneList",taskFromDoneList);
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
    }
}