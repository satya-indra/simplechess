package org.example.input.factory;

import org.example.constants.Constants;
import org.example.input.InputValidator;
import org.example.input.impl.StandardConsoleInputValidator;

public class InputValidatorFactory {
    public static InputValidator getValidator() {
        switch (Constants.APP_TYPE.toLowerCase()) {
            case "console":
                return new StandardConsoleInputValidator();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }
}
