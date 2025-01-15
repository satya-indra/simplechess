package org.example.board;

import org.example.piece.Piece;

import java.util.List;

public abstract class AbstractBoard implements Board {
    protected Piece[][] board;

    public AbstractBoard() {
        this.board = new Piece[8][8];
    }

    @Override
    public void reset() {
        this.board = new Piece[8][8];
    }

    public abstract void displayBoard();

}
