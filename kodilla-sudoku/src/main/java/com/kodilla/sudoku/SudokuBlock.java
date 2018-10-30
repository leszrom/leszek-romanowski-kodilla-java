package com.kodilla.sudoku;

public class SudokuBlock {
    public static int getBlockNumber(int row, int column) {
        int blockNumber = 0;

        if(1 <= row && row <= 3 && 1 <= column && column <= 3)
            blockNumber = 1;
        else if (1 <= row && row <= 3 && 4 <= column && column <= 6)
            blockNumber = 2;
        else if (1 <= row && row <= 3 && 7 <= column && column <= 9)
            blockNumber = 3;

        else if(4 <= row && row <= 6 && 1 <= column && column <= 3)
            blockNumber = 4;
        else if (4 <= row && row <= 6 && 4 <= column && column <= 6)
            blockNumber = 5;
        else if (4 <= row && row <= 6 && 7 <= column && column <= 9)
            blockNumber = 6;

        else if(7 <= row && row <= 9 && 1 <= column && column <= 3)
            blockNumber = 7;
        else if (7 <= row && row <= 9 && 4 <= column && column <= 6)
            blockNumber = 8;
        else if (7 <= row && row <= 9 && 7 <= column && column <= 9)
            blockNumber = 9;

        return blockNumber;
    }
}
