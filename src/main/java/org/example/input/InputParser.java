package org.example.input;

public interface InputParser {
    UserInput parse(String input);

    default boolean inputPatternMatcher(String input, String pattern) {
        if (input == null || input.isBlank()) {
            return false;
        }

        return input.trim().matches(pattern);
    }

}
