package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void registerObserver(TaskQueueObserver taskQueueObserver);

    void notifyObserver();

    void removeObserver(TaskQueueObserver taskQueueObserver);

}
