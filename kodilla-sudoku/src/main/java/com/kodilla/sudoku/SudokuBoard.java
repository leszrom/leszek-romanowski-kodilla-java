package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuBoard {
    private List<SudokuRow> rows = new ArrayList<>(9);

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            rows.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return rows.stream()
                .map(SudokuRow::toString)
    }
}
