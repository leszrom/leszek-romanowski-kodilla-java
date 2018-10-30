package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value = EMPTY;
    private List<Integer> possibleValues = new ArrayList<>();
    private final int rowNumber;
    private final int columnNumber;

    public SudokuElement(final int rowNumber, final int columnNumber) {
        for (int n = 1; n <= 9; n++) {
            possibleValues.add(n);
        }
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public int getValue() {
        return value;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPossibleValues(final Integer[] possibleValues) {
        this.possibleValues = possibleValues;
    }

    @Override
    public String toString() {
        String s = " " + value + " ";
        if (value == EMPTY)
            s = "   ";
        return s;
    }
}