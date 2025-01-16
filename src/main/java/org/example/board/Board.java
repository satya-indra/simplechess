package org.example.board;

import org.example.piece.Piece;

import java.util.List;

public interface Board {
    void reset();

    void displayBoard();

    void addAvailableMoves(List<Position> availableMoves, Piece piece);
}
