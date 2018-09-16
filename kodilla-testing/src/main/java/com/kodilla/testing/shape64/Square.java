package com.kodilla.testing.shape64;

public class Square implements Shape {
    private double edgeLength;

    public Square(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return edgeLength * edgeLength;
    }
}
