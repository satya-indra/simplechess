package org.example.input;

import org.example.board.Position;
import org.example.piece.PIECE_TYPE;
import org.example.piece.Piece;

public record UserInput(PIECE_TYPE piece, Position position) {

}
