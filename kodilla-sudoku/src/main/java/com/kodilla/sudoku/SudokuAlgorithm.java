package com.kodilla.sudoku;

import java.util.stream.Stream;

public class SudokuAlgorithm {
    private SudokuBoard board;

    public SudokuAlgorithm(SudokuBoard board) {
        this.board = board;
    }

    public Stream<SudokuElement> streamElements() {
        return board.getRows().stream()
                .flatMap(row-> row.getElements().stream());
    }

                .anyMatch(element -> element.getValue() == SudokuElement.EMPTY);
    }

    public boolean solveSudoku() {



        return true;
    }

}
