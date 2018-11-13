package com.kodilla.sudoku;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.stream.Stream;

public class SudokuAlgorithm {
    private SudokuBoard board;
    private ArrayDeque<SudokuBackup> backtrack = new ArrayDeque<>();

    public SudokuAlgorithm(SudokuBoard board) {
        this.board = board;
    }

    public Stream<SudokuElement> streamElements() {
        return board.getRows().stream()
                .flatMap(row-> row.getElements().stream());
    }

    public boolean isNotSolved() {
        return streamElements()
                .anyMatch(element -> element.getValue() == SudokuElement.EMPTY);
    }

    public boolean existEmptyElementWithoutAnyPossibleValue() {
        return streamElements()
                .filter(element -> element.getValue() == SudokuElement.EMPTY)
                .anyMatch(element -> element.getPossibleValues().isEmpty());
    }

    public boolean insertedWithoutGuessing() {
        Optional<Boolean> insertedWithoutGuessing;
            insertedWithoutGuessing = streamElements()
                    .filter(element -> element.getValue() == SudokuElement.EMPTY)
                    .filter(element -> element.getPossibleValues().size() == 1)
                    .findFirst()
                    .map(element -> addToBacktrack(board, element))
                    .map(element -> board.insertValue(element.getRowNumber(), element.getColumnNumber(), element.getPossibleValues().get(0)));
        return insertedWithoutGuessing.orElse(false);
    }

    public boolean insertedGuessedValue() {
        Optional<Boolean> insertedGuessedValue;
        insertedGuessedValue = streamElements()
                .filter(element -> element.getValue() == SudokuElement.EMPTY)
                .findFirst()
                .map(element -> addToBacktrack(board, element))
                .map(element -> board.insertValue(element.getRowNumber(), element.getColumnNumber(), element.getPossibleValues().get(0)));
        return insertedGuessedValue.orElse(false);
    }

    public SudokuBoard solveSudoku() {
        System.out.println(board);
        while (isNotSolved()) {
            while (insertedWithoutGuessing()) {
                while (existEmptyElementWithoutAnyPossibleValue()) {
                    this.board = backtrack.pop().getUpdatedBoard();
                }
            }
            if (isNotSolved()) {
                if (!insertedGuessedValue()) {
                    this.board = backtrack.pop().getUpdatedBoard();
                }
            }
        }
        System.out.println(UserInterface.SOLVED_SUDOKU);
        System.out.println(board);
        return board;
    }

    private SudokuElement addToBacktrack(SudokuBoard board, SudokuElement element){
        SudokuBoard clonedBoard = board;
        try {
            clonedBoard = board.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        backtrack.push(new SudokuBackup(clonedBoard, element.getRowNumber(), element.getColumnNumber() ,element.getPossibleValues().get(0)));
        return element;
    }
}
