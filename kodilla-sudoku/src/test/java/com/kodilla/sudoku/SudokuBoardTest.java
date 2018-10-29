package com.kodilla.sudoku;

import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SudokuBoardTest {

    @Test
    public void should_return_graphical_representation_of_empty_sudoku_board_and_with_example_value() {
        //Given
        SudokuBoard board = new SudokuBoard();
        //When
        System.out.println(board + "\n");
        board.getRows().stream()
                .flatMap(sudokuRow -> sudokuRow.getElements().stream())
                .forEach(sudokuElement -> sudokuElement.setValue(3));
        System.out.println(board);
        //Then
    }
}