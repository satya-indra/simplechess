package org.example.input;

public class StandardConsoleInputParser implements InputParser {
    private static final String INPUT_PATTERN = "^(?i)[a-z]+,\\s*[a-h][1-8]$";
    @Override
    public UserInput parse(String input) {
        boolean validPattern = inputPatternMatcher(input, INPUT_PATTERN);
        return null;
    }
}
