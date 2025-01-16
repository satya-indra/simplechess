package org.example.factory;

import org.example.board.Board;
import org.example.board.EmptyBoard;
import org.example.constants.Constants;
import org.example.input.InputValidator;
import org.example.input.impl.StandardConsoleInputValidator;

public class BoardFactory {
    public static Board getBoard(String appType) {
        switch (appType) {
            case Constants.CONSOLE_APP:
                return new EmptyBoard();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }

}
