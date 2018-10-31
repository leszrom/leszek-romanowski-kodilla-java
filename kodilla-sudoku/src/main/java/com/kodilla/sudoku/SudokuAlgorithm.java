package com.kodilla.sudoku;

public class SudokuAlgorithm {
    private SudokuBoard board = new SudokuBoard();

    public boolean solveSudoku() {



        return true;
    }

    public static SudokuBoard createSampleBoard() {

        SudokuBoard board = new SudokuBoard();

        board.insertValue(1, 2, 2);
        board.insertValue(1, 4, 5);
        board.insertValue(1, 6, 1);
        board.insertValue(1, 8, 9);

        board.insertValue(2, 1, 8);
        board.insertValue(2, 4, 2);
        board.insertValue(2, 6, 3);
        board.insertValue(2, 9, 6);

        board.insertValue(3, 2, 3);
        board.insertValue(3, 5, 6);
        board.insertValue(3, 8, 7);

        board.insertValue(4, 3, 1);
        board.insertValue(4, 7, 6);

        board.insertValue(5, 1, 5);
        board.insertValue(5, 2, 4);
        board.insertValue(5, 8, 1);
        board.insertValue(5, 9, 9);

        board.insertValue(6, 3, 2);
        board.insertValue(6, 7, 7);

        board.insertValue(7, 2, 9);
        board.insertValue(7, 5, 3);
        board.insertValue(7, 8, 8);

        board.insertValue(8, 1, 2);
        board.insertValue(8, 4, 8);
        board.insertValue(8, 6, 4);
        board.insertValue(8, 9, 7);

        board.insertValue(9, 2, 1);
        board.insertValue(9, 4, 9);
        board.insertValue(9, 6, 7);
        board.insertValue(9, 8, 6);

        return board;
    }
}
