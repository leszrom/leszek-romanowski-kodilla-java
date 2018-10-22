package com.kodilla.patterns.prototype.board;

import com.kodilla.patterns.prototype.board.Board;
import com.kodilla.patterns.prototype.board.Task;
import com.kodilla.patterns.prototype.board.TaskList;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {

    @Test
    public void should_return_toString_result() {
        //Given
        //creating the TaskList fot todos
        TaskList listToDo = new TaskList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number: " + n)));

        TaskList listInProgress = new TaskList("In Progress tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number: " + n)));

        TaskList listDone = new TaskList("Done tasks");
        IntStream.iterate(1, n -> n = 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number: " + n)));
        //When
        Board board = new Board("Project 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        //making a shallow copy of object board
        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        // making a deep copy of object board
        Board deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        board.getLists().remove(listToDo);

        //Then
        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedBoard);

        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(2, clonedBoard.getLists().size());
        Assert.assertEquals(3, deepClonedBoard.getLists().size());
        Assert.assertEquals(clonedBoard.getLists(), board.getLists());
        Assert.assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }
}