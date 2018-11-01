package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

public class SudokuRowTestSuite {

    @Test
    public void should_return_DeepCopy_of_sudoku_row() throws CloneNotSupportedException {
        //Given
        SudokuRow row = new SudokuRow(5);
        SudokuElement theElement = new SudokuElement(5, 3);
        SudokuRow clonedRow = row.deepCopy();
        //When
        clonedRow.getElements().remove(theElement);
        //Then
        Assert.assertTrue(row.getElements().contains(theElement));
        Assert.assertFalse(clonedRow.getElements().contains(theElement));
    }
}