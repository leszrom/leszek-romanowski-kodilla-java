package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Bean
    Board getBoard(){
        return new Board(getTaskList(),getTaskList(),getTaskList());
    }

    @Bean
    @Scope("prototype")
    public TaskList getTaskList(){
        return new TaskList();
    }
/*  Alternative solution
    @Bean
    Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }

    @Bean(name = "toDoList")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    public TaskList getDoneList() {
        return new TaskList();
    }
    */
}
