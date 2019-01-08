package com.kodilla.patterns2.observer.homework;

public class Menthor implements TaskQueueObserver {
    private final String mentorName;
    private int updateCount;

    public Menthor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(StudentTaskQueue studentTaskQueue) {
        System.out.println(mentorName + ", new task waiting for your review !!!"
                + "\n" + studentTaskQueue.getStudentName() + " tasks: "
                + studentTaskQueue.getTasks().size());
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
