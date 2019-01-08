package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuRow extends Prototype {
    private List<SudokuElement> elements = new ArrayList<>(9);
    private int rowNumber;

    public SudokuRow(final int rowNumber) {
        for (int n = 1; n <= 9; n++) {
            elements.add(new SudokuElement(rowNumber, n));
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof SudokuRow)) return false;

        final SudokuRow sudokuRow = (SudokuRow) o;

        if (rowNumber != sudokuRow.rowNumber) return false;
        return elements.equals(sudokuRow.elements);
    }

    @Override
    public int hashCode() {
        int result = elements.hashCode();
        result = 31 * result + rowNumber;
        return result;
    }

    public SudokuRow deepCopy() throws CloneNotSupportedException {
        SudokuRow clonedRow = (SudokuRow) super.clone();
        clonedRow.elements = new ArrayList<>(9);
        for (SudokuElement theElement : elements) {
            clonedRow.elements.add(theElement.deepCopy());
        }
        return clonedRow;
    }
}