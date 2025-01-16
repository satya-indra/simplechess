package org.example.factory;

import org.example.constants.Constants;
import org.example.game.Playable;
import org.example.game.StandardConsoleGame;
import org.example.io.GameIO;

public class GameFactory {
    public static Playable createGame(GameIO io, String appType) {
        switch (appType) {
            case Constants.CONSOLE_APP:
                return new StandardConsoleGame(BoardFactory.getBoard(appType), io);
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }
}
