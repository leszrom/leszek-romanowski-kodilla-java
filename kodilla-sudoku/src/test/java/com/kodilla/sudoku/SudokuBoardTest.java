package com.kodilla.sudoku;

import org.junit.Assert;
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

    @Test
    public void should_return_true_and_insert_value_to_board() {
        //Given
        SudokuBoard board = new SudokuBoard();
        //When
        boolean result = board.insertValue(2, 8, 2);
        System.out.println(board);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(2, board.getRows().get(8 - 1).getElements().get(2 - 1).getValue());
    }

    @Test
    public void should_return_false_when_index_is_out_of_board_or_value_is_not_allowed() {
        //Given
        SudokuBoard board = new SudokuBoard();
        //When
        boolean isRowInRange = board.insertValue(3, 10, 3);
        boolean isColumnInRange = board.insertValue(0, 3, 3);
        boolean isValueInRange = board.insertValue(3, 3, 10);
        //Then
        Assert.assertFalse(isRowInRange);
        Assert.assertFalse(isColumnInRange);
        Assert.assertFalse(isValueInRange);
    }
}