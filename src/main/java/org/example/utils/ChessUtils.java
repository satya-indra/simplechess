package org.example.utils;

import org.example.board.Position;
import org.example.piece.PIECE_TYPE;

import java.util.Optional;

public interface ChessUtils {
    Optional<PIECE_TYPE> toPieceType(String pieceName);
    Optional<Position> toPosition(String positionName);
    Optional<String> toString(Position position);
}
