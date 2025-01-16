package org.example.factory;

import org.example.constants.Constants;
import org.example.dto.StandardConsoleUserInput;
import org.example.dto.UserInput;

public class UserInputFactory {
    public static UserInput getInputInstance() {
        switch (Constants.APP_TYPE.toLowerCase()) {
            case "console":
                return new StandardConsoleUserInput();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }
}
