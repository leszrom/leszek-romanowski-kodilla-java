package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

public class SudokuAlgorithmTestSuite {
    @Test
    public void should_return_sample_sudoku_board() {
        //Given
        System.out.println(SudokuBoardTestSuite.createSampleBoard());
        //When

        //Then

    @Test
    public void should_return_stream_of_all_elements_from_board() {
        //Given
        SudokuBoard board = new SudokuBoard();
        SudokuAlgorithm algorithm = new SudokuAlgorithm(board);
        //When
        long numberOfElements = algorithm.streamElements().count();
        //Then
        Assert.assertEquals(81,numberOfElements);
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

    @Test
    public void should_return_true_if_exist_empty_element_without_any_possible_value_to_insert() {
        //Given
        SudokuBoard board = new SudokuBoard();
        SudokuAlgorithm algorithm = new SudokuAlgorithm(board);
        //When
        board.insertValue(1, 1, 1);
        board.insertValue(1, 2, 2);
        board.insertValue(1, 3, 3);
        board.insertValue(1, 4, 4);
        board.insertValue(1, 5, 5);
        board.insertValue(1, 6, 6);
        board.insertValue(1, 7, 7);
        board.insertValue(1, 8, 8);
        board.insertValue(2, 9, 9);
        //Then
        Assert.assertTrue(algorithm.existEmptyElementWithoutAnyPossibleValue());
    }

}