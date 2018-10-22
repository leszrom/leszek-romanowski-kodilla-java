package com.kodilla.patterns.prototype.board;

public final class Task {
    private final String name;

    public Task(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "        Task [" +name + "]";
    }
}
