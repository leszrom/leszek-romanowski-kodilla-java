package com.kodilla.spring.intro.shape;

public class Circle implements Shape {
    private String thisIs = "This is a circle";

    @Override
    public String draw() {
        System.out.println(thisIs);
        return thisIs;
    }
}
