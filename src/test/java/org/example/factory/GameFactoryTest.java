package org.example.factory;

import org.example.board.EmptyBoard;
import org.example.constants.Constants;
import org.example.game.Playable;
import org.example.game.StandardConsoleGame;
import org.example.io.GameIO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class GameFactoryTest {
    @Test
    void testCreateGame_ConsoleApp() {
        // Mock the GameIO dependency
        GameIO ioMock = mock(GameIO.class);

        // Call the factory method with valid app type
        Playable game = GameFactory.createGame(ioMock, Constants.CONSOLE_APP);

        // Validate the returned game instance
        assertNotNull(game, "Game should not be null for console app type");
        assertTrue(game instanceof StandardConsoleGame, "Expected an instance of StandardConsoleGame for console app type");

        // Validate that the game uses the correct board
        StandardConsoleGame consoleGame = (StandardConsoleGame) game;

        assertNotNull(consoleGame.getBoard(), "Board should not be null for console game");
        assertTrue(consoleGame.getBoard() instanceof EmptyBoard, "Expected an EmptyBoard for console app type");
    }

    @Test
    void testCreateGame_InvalidAppType() {
        // Mock the GameIO dependency
        GameIO ioMock = mock(GameIO.class);

        // Call the factory method with an invalid app type
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> GameFactory.createGame(ioMock, "INVALID_APP_TYPE"),
                "Expected an exception for unknown app type");

        // Validate the exception message
        assertEquals("Unknown app type", exception.getMessage(), "Exception message should match expected value");
    }

    @Test
    void testCreateGame_EmptyAppType() {
        // Mock the GameIO dependency
        GameIO ioMock = mock(GameIO.class);

        // Call the factory method with an empty app type
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> GameFactory.createGame(ioMock, ""),
                "Expected an exception for empty app type");

        // Validate the exception message
        assertEquals("Unknown app type", exception.getMessage(), "Exception message should match expected value");
    }
}
