package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuRow {
    private List<SudokuElement> elements = new ArrayList<>(Collections.nCopies(9,new SudokuElement()));

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