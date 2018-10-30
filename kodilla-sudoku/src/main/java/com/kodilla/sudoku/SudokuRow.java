package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuRow {
    private List<SudokuElement> elements = new ArrayList<>(9);
    private int rowNumber;

    public SudokuRow(final int rowNumber) {
        for (int n = 1; n <= 9; n++) {
            elements.add(new SudokuElement(rowNumber,n));
        }
        this.rowNumber = rowNumber;
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    @Override
    public String toString() {
        return elements.stream()
                .map(SudokuElement::toString)
                .collect(Collectors.joining("|", " --- --- --- --- --- --- --- --- ---\n|", "|"));
    }
}