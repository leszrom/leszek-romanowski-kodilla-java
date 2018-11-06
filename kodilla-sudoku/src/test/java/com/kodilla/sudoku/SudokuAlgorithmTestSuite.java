package com.kodilla.sudoku;

import org.junit.Test;

public class SudokuAlgorithmTestSuite {
    @Test
    public void should_return_sample_sudoku_board() {
        //Given
        System.out.println(SudokuBoardTestSuite.createSampleBoard());
        //When

        //Then

    }

    @Test
    public void should_return_false_if_sudoku_is_solved() {
        //Given
        SudokuBoard emptyBoard = new SudokuBoard();
        SudokuBoard sampleBoard = SudokuBoardTestSuite.createSampleBoard();
        SudokuBoard fullBoard = new SudokuBoard();
        fullBoard.getRows().stream()
                .flatMap(row -> row.getElements().stream())
                .forEach(element -> element.setValue(3));
        System.out.println(emptyBoard);
        System.out.println(sampleBoard);
        System.out.println(fullBoard);
        //When
        SudokuAlgorithm algorithmEmptyBoard = new SudokuAlgorithm(emptyBoard);
        SudokuAlgorithm algorithmSampleBoard = new SudokuAlgorithm(sampleBoard);
        SudokuAlgorithm algorithmFullBoard = new SudokuAlgorithm(fullBoard);
        //Then
        Assert.assertTrue(algorithmEmptyBoard.isNotSolved());
        Assert.assertTrue(algorithmSampleBoard.isNotSolved());
        Assert.assertFalse(algorithmFullBoard.isNotSolved());
    }
}