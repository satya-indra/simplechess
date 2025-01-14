package org.example.tranformer;

import org.example.board.Position;
import org.example.piece.PIECE_TYPE;

import java.util.Optional;

public interface Transformer {
    Optional<PIECE_TYPE> toPieceType(String pieceName);
    Optional<Position> toPosition(String positionName);
}
