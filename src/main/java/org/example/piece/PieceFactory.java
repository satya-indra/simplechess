package org.example.piece;

import org.example.constants.Constants;
import org.example.input.InputValidator;
import org.example.input.impl.StandardConsoleInputValidator;

import java.util.Arrays;

public class PieceFactory {
    public static Piece getPiece(PIECE_TYPE pieceType) {
        switch (pieceType) {
            case KING:
                return new King();
            case QUEEN:
                return new Queen();
            case PAWN:
                return new Pawn();
            default:
                throw new IllegalArgumentException("Unknown Piece Type. Allowed Piece are : " + Arrays.toString(PIECE_TYPE.values()));
        }
    }
}
