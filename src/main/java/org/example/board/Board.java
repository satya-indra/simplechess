package org.example.board;

import org.example.piece.Piece;

import java.util.List;

public interface Board {
    void initialize();
    void reset();

    public void displayBoard();

    public void addAvailableMoves(List<Position> availableMoves, Piece piece);
}
