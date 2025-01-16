package org.example.factory;

import org.example.constants.Constants;
import org.example.input.InputValidator;
import org.example.input.impl.StandardConsoleInputValidator;
import org.example.piece.*;

import java.util.Arrays;

public class PieceFactory {
    public static Piece getPiece(PIECE_TYPE pieceType) {
        return switch (pieceType) {
            case KING -> new King();
            case QUEEN -> new Queen();
            case PAWN -> new Pawn();
        };
    }
}
