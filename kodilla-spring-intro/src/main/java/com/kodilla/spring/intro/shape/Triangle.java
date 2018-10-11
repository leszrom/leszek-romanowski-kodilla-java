package com.kodilla.spring.intro.shape;

public class Triangle implements Shape {
    private String thisIs = "This is a triangle";

    @Override
    public String draw() {
        System.out.println(thisIs);
        return thisIs;
    }
}
