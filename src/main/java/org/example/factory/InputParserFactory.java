package org.example.factory;

import org.example.constants.Constants;
import org.example.input.InputParser;
import org.example.input.impl.StandardConsoleInputParser;

public class InputParserFactory {
    public static InputParser getInputParser() {
        switch (Constants.APP_TYPE.toLowerCase()) {
            case "console":
                return new StandardConsoleInputParser();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }
}
