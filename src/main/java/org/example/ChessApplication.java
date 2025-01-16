package org.example;

import org.example.game.Playable;
import org.example.factory.GameFactory;
import org.example.io.StandardConsoleIO;
import org.example.io.GameIO;

public class ChessApplication {

    public static void main(String[] args) {
        GameIO io = new StandardConsoleIO();
        Playable game = GameFactory.createGame(io);
        game.play();
    }

}