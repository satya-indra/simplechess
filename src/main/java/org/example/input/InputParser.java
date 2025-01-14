package org.example.input;

import java.util.Optional;

public interface InputParser {
    Optional<UserInput> parse(String input);

    default boolean inputPatternMatcher(String input, String pattern) {
        if (input == null || input.isBlank()) {
            return false;
        }

        return input.trim().matches(pattern);
    }

}
