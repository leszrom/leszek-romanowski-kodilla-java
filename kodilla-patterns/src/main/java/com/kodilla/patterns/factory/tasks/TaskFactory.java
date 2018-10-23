package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "Shopping task";
    public static final String PAINTING = "Painting task";
    public static final String DRIVING = "Driving task";

    public final Task createTask(final String taskType) {
        switch (taskType) {
            case SHOPPING:
                return new ShoppingTask("Shopping for Ben", "brushes", 5);
            case PAINTING:
                return new PaintingTask("Door painting","blue","door");
            case DRIVING:
                return new DrivingTask("Drive home","home","car");
            default:
                return null;
        }
    }
}
