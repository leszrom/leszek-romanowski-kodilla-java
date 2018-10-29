package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> elements = new ArrayList<>(Collections.nCopies(9,new SudokuElement()));

    public List<SudokuElement> getElements() {
        return elements;
    }
}
