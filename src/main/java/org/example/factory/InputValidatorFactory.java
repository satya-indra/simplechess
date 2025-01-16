package org.example.factory;

import org.example.constants.Constants;
import org.example.input.InputValidator;
import org.example.input.impl.StandardConsoleInputValidator;

public class InputValidatorFactory {
    public static InputValidator getValidator(String appType) {
        switch (appType) {
            case Constants.CONSOLE_APP:
                return new StandardConsoleInputValidator();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }
}
