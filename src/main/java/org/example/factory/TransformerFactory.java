package org.example.factory;

import org.example.constants.Constants;
import org.example.utils.StandardConsoleChessUtils;
import org.example.utils.ChessUtils;

public class TransformerFactory {

    public static ChessUtils getTransformer(String appType) {
        switch (appType) {
            case Constants.CONSOLE_APP:
                return new StandardConsoleChessUtils();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }

}
