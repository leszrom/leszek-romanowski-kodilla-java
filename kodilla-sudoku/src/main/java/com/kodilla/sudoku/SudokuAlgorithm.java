package com.kodilla.sudoku;

public class SudokuAlgorithm {
    private SudokuBoard board;

    public SudokuAlgorithm(SudokuBoard board) {
        this.board = board;
    }

    public boolean isNotSolved() {
        return board.getRows().stream()
                .flatMap(row -> row.getElements().stream())
                .anyMatch(element -> element.getValue() == SudokuElement.EMPTY);
    }

    public boolean solveSudoku() {



        return true;
    }

}
