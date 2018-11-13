package com.kodilla.sudoku;

public class SudokuGame {
    private SudokuBoard board = new SudokuBoard();

    public boolean resolveSudoku() {
        System.out.println(board);
        System.out.println(UserInterface.INSTRUCTIONS);
        while (!definedBoard(UserInterface.getInput())) {
            System.out.println(board);
        }
        SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm(board);
        sudokuAlgorithm.solveSudoku();

        return UserInterface.wantToFinish();
    }

    public boolean definedBoard(String input) {

        if (input.equalsIgnoreCase(UserInterface.SUDOKU_PATTERN)) {
            return true;
        }

        String[] stringsArray = input.split(",");
        for (int i = 0; i < stringsArray.length; i += 3) {
            int row = Integer.parseInt(stringsArray[i]);
            int column = Integer.parseInt(stringsArray[i + 1]);
            int value = Integer.parseInt(stringsArray[i + 2]);
            board.insertValue(row, column, value);
        }
        return false;
    }
}
