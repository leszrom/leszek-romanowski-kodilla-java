package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentTaskQueue implements Observable {
    private final List<TaskQueueObserver> observers;
    private final List<String> tasks;
    private final String studentName;

    public StudentTaskQueue(String studentName) {
        observers = new ArrayList<>();
        tasks = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObserver();
    }

    @Override
    public void registerObserver(TaskQueueObserver taskQueueObserver) {
        observers.add(taskQueueObserver);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(mentor -> mentor.update(this));
    }

    @Override
    public void removeObserver(TaskQueueObserver taskQueueObserver) {
        observers.remove(taskQueueObserver);
    }

    public List<TaskQueueObserver> getObservers() {
        return observers;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getStudentName() {
        return studentName;
    }
}

