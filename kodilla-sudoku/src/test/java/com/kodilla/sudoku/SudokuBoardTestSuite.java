package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SudokuBoardTestSuite {

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

    @Test
    public void should_return_graphical_representation_of_sample_sudoku_board() {
        //Given
        SudokuBoard board = SudokuBoardTestSuite.createSampleBoard();
        //When
        //Then
        System.out.println(board);
    }

    @Test
    public void should_return_true_and_insert_value_to_board_and_empty_list_of_possible_values() {
        //Given
        SudokuBoard board = new SudokuBoard();
        //When
        boolean result = board.insertValue(2, 8, 2);
        SudokuElement element = board.getRows().get(1).getElements().get(7);

        System.out.println(board);
        System.out.println(element.getPossibleValues());
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(2, element.getValue());
        Assert.assertEquals(0, element.getPossibleValues().size());
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

    @Test
    public void should_return_false_if_element_already_has_inserted_value() {
        //Given
        SudokuBoard board = new SudokuBoard();
        board.insertValue(7, 6, 5);
        //When
        boolean result = board.insertValue(7, 6, 5);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void should_delete_inserted_value_from_possible_values_in_fields_in_row_column_and_block() {
        //Given
        SudokuBoard board = new SudokuBoard();
        int row = 2;
        int column = 4;
        int value = 3;
        board.updatePossibleValues(row, column, value);
        //When
        SudokuElement elementFromRow = board.getRows().get(row - 1).getElements().get(8);
        SudokuElement elementFromColumn = board.getRows().get(5).getElements().get(column - 1);
        SudokuElement elementFromBlock = board.getRows().get(2).getElements().get(5);
        SudokuElement elementNoInfluence = board.getRows().get(5).getElements().get(5);

        //Then
        System.out.println(elementFromRow.getPossibleValues());
        System.out.println(elementFromColumn.getPossibleValues());
        System.out.println(elementFromBlock.getPossibleValues());
        System.out.println(elementNoInfluence.getPossibleValues());

        Assert.assertFalse(elementFromRow.getPossibleValues().contains(3));
        Assert.assertFalse(elementFromColumn.getPossibleValues().contains(3));
        Assert.assertFalse(elementFromBlock.getPossibleValues().contains(3));
        Assert.assertTrue(elementNoInfluence.getPossibleValues().contains(3));
    }
}