package org.example.board.factory;

import org.example.board.Board;
import org.example.board.EmptyBoard;
import org.example.constants.Constants;
import org.example.input.InputValidator;
import org.example.input.impl.StandardConsoleInputValidator;

public class BoardFactory {
    public static Board getBoard() {
        switch (Constants.APP_TYPE.toLowerCase()) {
            case "console":
                return new EmptyBoard();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }

}
