package org.example.game;

import org.example.board.Board;
import org.example.input.UserInput;
import org.example.io.GameIO;

public abstract class Game {
    protected Board board;
    protected GameIO gameIO;

    public abstract Board play();

}
