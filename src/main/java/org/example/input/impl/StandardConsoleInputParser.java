package org.example.input.impl;

import org.example.input.InputParser;
import org.example.input.UserInput;
import org.example.input.factory.InputValidatorFactory;

import java.util.Optional;

public class StandardConsoleInputParser implements InputParser {
    private static final String INPUT_PATTERN = "^(?i)[a-z]+,\\s*[a-h][1-8]$";
    @Override
    public Optional<UserInput> parse(String input) {

        boolean validPattern = inputPatternMatcher(input, INPUT_PATTERN);

        if (!validPattern) {
            System.out.println("Invalid user input. Correct input example: king, b4");
            return Optional.empty();
        }

        return InputValidatorFactory.getValidator().validate(input);
    }
}
