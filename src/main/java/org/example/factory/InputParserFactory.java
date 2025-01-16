package org.example.factory;

import org.example.constants.Constants;
import org.example.input.InputParser;
import org.example.input.impl.StandardConsoleInputParser;

public class InputParserFactory {
    public static InputParser getInputParser(String appType) {
        switch (appType) {
            case Constants.CONSOLE_APP:
                return new StandardConsoleInputParser();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }
}
