package org.example;

import org.example.game.Game;
import org.example.game.factory.GameFactory;
import org.example.io.ConsoleIO;
import org.example.io.GameIO;

public class ChessApplication {

    public static void main(String[] args) {
        GameIO io = new ConsoleIO();
        Game game = GameFactory.createGame(io);
        game.play();
    }
}