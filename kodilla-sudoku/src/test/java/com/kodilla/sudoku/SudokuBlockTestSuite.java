package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SudokuBlockTestSuite {

    @Test
    public void should_return_block_number_according_to_row_and_column_value() {
        //Given
        //When
        int elementFromBlock1 = SudokuBlock.getBlockNumber(1,1);
        int elementFromBlock2 = SudokuBlock.getBlockNumber(2,4);
        int elementFromBlock3 = SudokuBlock.getBlockNumber(3,7);
        int elementFromBlock4 = SudokuBlock.getBlockNumber(4,2);
        int elementFromBlock5 = SudokuBlock.getBlockNumber(5,5);
        int elementFromBlock6 = SudokuBlock.getBlockNumber(6,8);
        int elementFromBlock7 = SudokuBlock.getBlockNumber(7,3);
        int elementFromBlock8 = SudokuBlock.getBlockNumber(8,6);
        int elementFromBlock9 = SudokuBlock.getBlockNumber(9,9);
        //Then
        Assert.assertEquals(1,elementFromBlock1);
        Assert.assertEquals(2,elementFromBlock2);
        Assert.assertEquals(3,elementFromBlock3);
        Assert.assertEquals(4,elementFromBlock4);
        Assert.assertEquals(5,elementFromBlock5);
        Assert.assertEquals(6,elementFromBlock6);
        Assert.assertEquals(7,elementFromBlock7);
        Assert.assertEquals(8,elementFromBlock8);
        Assert.assertEquals(9,elementFromBlock9);
    }
}