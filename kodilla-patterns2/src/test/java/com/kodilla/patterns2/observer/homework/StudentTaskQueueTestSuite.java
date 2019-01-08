package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class StudentTaskQueueTestSuite {
    @Test
    public void should_notify_mentors_about_new_task_waiting_for_review() {
        //Given
        Menthor johnSmithMentor = new Menthor("John Smith");
        Menthor benFiveMentor = new Menthor("Ben Five");

        StudentTaskQueue adamTasks = new StudentTaskQueue("Adam");
        StudentTaskQueue lucyTasks = new StudentTaskQueue("Lucy");
        StudentTaskQueue roseTasks = new StudentTaskQueue("Rose");
        StudentTaskQueue dannyTasks = new StudentTaskQueue("Danny");
        StudentTaskQueue kateTasks = new StudentTaskQueue("Kate");
        StudentTaskQueue martinTasks = new StudentTaskQueue("Martin");

        adamTasks.registerObserver(johnSmithMentor);
        lucyTasks.registerObserver(johnSmithMentor);
        roseTasks.registerObserver(johnSmithMentor);
        roseTasks.registerObserver(benFiveMentor);
        dannyTasks.registerObserver(johnSmithMentor);
        dannyTasks.registerObserver(benFiveMentor);
        kateTasks.registerObserver(benFiveMentor);
        martinTasks.registerObserver(benFiveMentor);

        //When
        adamTasks.addTask("Collections");
        adamTasks.addTask("Testing");
        adamTasks.addTask("Loops");
        lucyTasks.addTask("Testing");
        roseTasks.addTask("Facade");
        dannyTasks.addTask("Loops");
        kateTasks.addTask("Factory");
        martinTasks.addTask("Collections");
        martinTasks.addTask("Testing");

        //Then
        Assert.assertEquals(6, johnSmithMentor.getUpdateCount());
        Assert.assertEquals(5, benFiveMentor.getUpdateCount());
    }
}
