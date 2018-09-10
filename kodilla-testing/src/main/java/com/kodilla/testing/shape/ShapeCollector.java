package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> figures = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        figures.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if (figures.contains(shape)) {
            figures.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int figureNumber) {
        if (figureNumber >=0 && figureNumber < figures.size())
            return figures.get(figureNumber);
        return null;
    }

    public int getFigureQuantity() {
        return figures.size();
    }
}
