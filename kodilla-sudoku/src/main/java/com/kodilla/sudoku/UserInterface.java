package com.kodilla.sudoku;

import java.util.Scanner;
import java.util.regex.Pattern;

public final class UserInterface {
    private static final String COORD_AND_VALUE_PATTERN = "^([1-9],[1-9],[1-9],?)+?$";
    private static final String ENTER_COMMAND = "Enter value: ";
    private static final String WRONG_CHOICE = "Wrong insertion...";
    private static final String WANT_TO_FINISH = "Do you want to finish?\n" +
            "For <Yes> press 'y', for <No> press any key.";
    public static final String SUDOKU_PATTERN = "SUDOKU";
    public static final String SOLVED_SUDOKU = "\nSolved Sudoku board:";
    public static final String INSTRUCTIONS = "Enter the values to insert.\n"+
            "*(pattern: row,column,value,row,column,value... ex. 2,6,7,6,3,5)\n" +
            "When the board is defined, type \"SUDOKU\" to solve (capitalization does not matter).\n"+
            "Each insertion confirm by pressing 'Enter'";
    public static final String CANT_INSERT ="I can't insert value: ";

    private static Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        System.out.print(ENTER_COMMAND);
        String line = scanner.nextLine();
        while (!matchesSudokuPattern(line) && !matchesCoordAndValuePattern(line)) {
            System.out.println(WRONG_CHOICE);
            line = scanner.nextLine();
        }
        return line;
    }

    public static boolean wantToFinish() {
        System.out.println(WANT_TO_FINISH);
        return scanner.nextLine().equals("y");
    }

    private static boolean matchesSudokuPattern(String line) {
        return line.equalsIgnoreCase(SUDOKU_PATTERN);
    }

    private static boolean matchesCoordAndValuePattern(String line) {
        return Pattern.compile(COORD_AND_VALUE_PATTERN).matcher(line).matches();
    }
}
