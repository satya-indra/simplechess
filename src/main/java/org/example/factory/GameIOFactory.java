package org.example.factory;

import org.example.constants.Constants;
import org.example.io.GameIO;
import org.example.io.StandardConsoleIO;

public class GameIOFactory {

    public static GameIO getInstance(String appType) {
        switch (appType) {
            case Constants.CONSOLE_APP:
                return new StandardConsoleIO();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }
}
