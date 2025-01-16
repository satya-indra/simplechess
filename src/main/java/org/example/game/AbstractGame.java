package org.example.game;

import lombok.Getter;
import org.example.board.Board;
import org.example.io.GameIO;

@Getter
public abstract class AbstractGame implements Playable {

    protected Board board;
    protected GameIO gameIO;

}
