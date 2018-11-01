package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuBoard extends Prototype {
    private List<SudokuRow> rows = new ArrayList<>(9);

    public SudokuBoard() {
        for (int n = 1; n <= 9; n++) {
            rows.add(new SudokuRow(n));
        }
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    public boolean insertValue(int row, int column, int value) {
        SudokuElement element;
        if (1 <= column && column <= 9) {
            if (1 <= row && row <= 9) {
                element = rows.get(row - 1).getElements().get(column - 1);
                if (element.getPossibleValues().contains(value)) {
                    element.setValue(value);
                    element.getPossibleValues().removeAll(element.getPossibleValues());
                    updatePossibleValues(row,column,value);
                    return true;
                }
            }
        }
        return false;
    }

    public void updatePossibleValues(int row, int column, int value) {
        int block = SudokuBlock.getBlockNumber(row, column);

        getRows().stream()
                .flatMap(sudokuRow -> sudokuRow.getElements().stream())
                .filter(sudokuElement -> sudokuElement.getColumnNumber() == column)
                .forEach(sudokuElement -> sudokuElement.deleteFromPossibleValues(value));

        getRows().stream()
                .flatMap(sudokuRow -> sudokuRow.getElements().stream())
                .filter(sudokuElement -> sudokuElement.getRowNumber() == row)
                .forEach(sudokuElement -> sudokuElement.deleteFromPossibleValues(value));

        getRows().stream()
                .flatMap(sudokuRow -> sudokuRow.getElements().stream())
                .filter(sudokuElement -> sudokuElement.getBlockNumber() == block)
                .forEach(sudokuElement -> sudokuElement.deleteFromPossibleValues(value));
    }

    @Override
    public String toString() {
        return rows.stream()
                .map(SudokuRow::toString)
                .collect(Collectors.joining("\n", "", "\n --- --- --- --- --- --- --- --- ---"));
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard cloneBoard = (SudokuBoard) super.clone();
        cloneBoard.rows = new ArrayList<>(9);
        for (SudokuRow theRow : rows) {
            cloneBoard.rows.add(theRow.deepCopy());
        }
        return cloneBoard;
    }
}
