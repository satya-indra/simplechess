package org.example.factory;

import org.example.board.Board;
import org.example.board.EmptyBoard;
import org.example.constants.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class BoardFactoryTest {
    @Test
    void testGetBoard_ConsoleApp() {

        // Call the factory method
        Board board = BoardFactory.getBoard(Constants.CONSOLE_APP);

        // Validate the returned board
        assertNotNull(board, "Board should not be null for console app type");
        assertTrue(board instanceof EmptyBoard, "Expected an instance of EmptyBoard for console app type");
    }
}
