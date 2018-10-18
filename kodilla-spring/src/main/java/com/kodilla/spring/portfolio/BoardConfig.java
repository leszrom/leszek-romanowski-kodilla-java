package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Bean
    Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }
//    @Bean
//    @Scope("prototype")
//    public TaskList getTaskList(){
//        return new TaskList();
////    }
    // Próbowałem jw. i w getBoard() przywołać getTaskList trzy razy i zadziałało (tzn. testy przeszły),
    // ale jak pobrałem listę beanów z kontenera to pokazł tylko jedną instancę z getTaskList().
    // Zastanawiam się które rozwiązanie jest właściwe.

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList getDoneList() {
        return new TaskList();
    }
}
