package org.example.factory;

import org.example.constants.Constants;
import org.example.dto.StandardConsoleUserInput;
import org.example.dto.UserInput;

public class UserInputFactory {
    public static UserInput getInputInstance(String appType) {
        switch (appType) {
            case Constants.CONSOLE_APP:
                return new StandardConsoleUserInput();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }
}
