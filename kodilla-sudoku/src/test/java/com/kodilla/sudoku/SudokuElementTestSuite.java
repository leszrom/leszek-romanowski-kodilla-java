package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SudokuElementTestSuite {

    @Test
    public void should_return_DeepCopy_of_sudoku_element() throws CloneNotSupportedException {
        //Given
        SudokuElement element = new SudokuElement(2, 3);
        SudokuElement cloneElement = element.deepCopy();
        //When
        cloneElement.setValue(8);
        cloneElement.deleteFromPossibleValues(3);
        //Then
        Assert.assertEquals(8,cloneElement.getValue());
        Assert.assertEquals(SudokuElement.EMPTY,element.getValue());

        Assert.assertFalse(cloneElement.getPossibleValues().contains(3));
        Assert.assertTrue(element.getPossibleValues().contains(3));
    }
}