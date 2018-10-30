package com.kodilla.sudoku;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value = EMPTY;
    private Integer[] possibleValues = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public int getValue() {
        return value;
    }

    public Integer[] getPossibleValues() {
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