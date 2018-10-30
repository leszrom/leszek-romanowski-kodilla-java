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
    public void should_delete_inserted_value_from_possible_values_in_fields_in_row_column_and_block() {
        //Given
        SudokuBoard board = new SudokuBoard();
        int row = 2;
        int column = 4;
        int value = 3;
        board.updatePossibleValues(row, column, value);
        //When
        SudokuElement elementFromRow = board.getRows().get(row-1).getElements().get(8);
        SudokuElement elementFromColumn = board.getRows().get(5).getElements().get(column-1);
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