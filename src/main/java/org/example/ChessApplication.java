package org.example;

import org.example.constants.Constants;
import org.example.game.Playable;
import org.example.factory.GameFactory;
import org.example.factory.GameIOFactory;

public class ChessApplication {
    public static void main(String[] args) {
        String appType = Constants.APP_TYPE;

        Playable game = GameFactory
                .createGame(GameIOFactory
                        .getInstance(appType),
                        appType);

        game.play();
    }

}