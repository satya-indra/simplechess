package org.example.factory;

import org.example.constants.Constants;
import org.example.game.Playable;
import org.example.game.StandardConsoleGame;
import org.example.io.GameIO;

public class GameFactory {
    public static Playable createGame(GameIO io) {
        switch (Constants.APP_TYPE.toLowerCase()) {
            case "console":
                return new StandardConsoleGame(BoardFactory.getBoard(), io);
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }
}
