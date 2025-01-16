package org.example.dto;

import org.example.board.Position;
import org.example.piece.PIECE_TYPE;

public abstract class UserInput {
    PIECE_TYPE piece;
    Position position;

    public PIECE_TYPE getPiece() {
        return piece;
    }

    public void setPiece(PIECE_TYPE piece) {
        this.piece = piece;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
