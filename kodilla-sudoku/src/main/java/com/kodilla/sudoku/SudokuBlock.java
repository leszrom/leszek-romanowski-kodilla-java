package com.kodilla.sudoku;

public class SudokuBlock {
    public static int getBlockNumber(int row, int column) {

        if (row <= 3) {
            if (column <= 3) {
                return 1;
            } else if (column <= 6) {
                return 2;
            } else if (column <= 9)
                return 3;
        } else if (row <= 6) {
            if (column <= 3) {
                return 4;
            } else if (column <= 6) {
                return 5;
            } else if (column <= 9)
                return 6;
        } else if (row <= 9) {
            if (column <= 3) {
                return 7;
            } else if (column <= 6) {
                return 8;
            } else if (column <= 9) {
                return 9;
            }
        }
        return 0;
    }
}
