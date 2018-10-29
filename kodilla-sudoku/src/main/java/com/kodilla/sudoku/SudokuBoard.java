package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuBoard {
    private List<SudokuRow> rows = new ArrayList<>(Collections.nCopies(9, new SudokuRow()));

    public List<SudokuRow> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return rows.stream()
                .map(SudokuRow::toString)
                .collect(Collectors.joining("\n","","\n --- --- --- --- --- --- --- --- ---"));
    }
}
