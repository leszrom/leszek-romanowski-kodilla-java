package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuRow {
    private List<SudokuElement> elements = new ArrayList<>(9);

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            elements.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return elements.stream()
                .map(SudokuElement::toString)
                .collect(Collectors.joining("|"," --- --- --- --- --- --- --- --- ---\n|","|"));
    }
}