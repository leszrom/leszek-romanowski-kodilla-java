package com.kodilla.testing.shape64;

public class Triangle implements Shape {
    private double edgeLength;
    private double hight;

    public Triangle(double edgeLength, double hight) {
        this.edgeLength = edgeLength;
        this.hight = hight;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return (edgeLength * hight) / 2;
    }
}
