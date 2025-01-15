package org.example.game.factory;

import org.example.board.factory.BoardFactory;
import org.example.constants.Constants;
import org.example.game.Game;
import org.example.game.SimpleConsoleGame;
import org.example.io.GameIO;

public class GameFactory {
    public static Game createGame(GameIO io) {
        switch (Constants.APP_TYPE.toLowerCase()) {
            case "console":
                return new SimpleConsoleGame(BoardFactory.getBoard(), io);
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }
}
