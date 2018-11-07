package com.kodilla.sudoku;

public class SudokuBackup {
    private SudokuBoard board;
    private int row;
    private int column;
    private int guessedValue;

    public SudokuBackup(SudokuBoard board, int row, int column, int guessedValue) {
        this.board = board;
        this.row = row;
        this.column = column;
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getUpdatedBoard() {
        board.getRows().get(row-1).getElements().get(column-1).deleteFromPossibleValues(guessedValue);
        return board;
    }

}
