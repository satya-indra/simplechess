package org.example.input;

import org.example.board.Position;
import org.example.piece.PIECE_TYPE;

public record UserInput(PIECE_TYPE piece, Position position) {

}
