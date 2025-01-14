package org.example.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {
    InputParser inputParser = new StandardConsoleInputParser();
    static final String INPUT_PATTERN = "^(?i)[a-z]+,\\s*[a-h][1-8]$";

    @Test
    void testValidInputs() {
        assertTrue(inputParser.inputPatternMatcher("king, b4", INPUT_PATTERN), "Valid input with lowercase piece and position");
        assertTrue(inputParser.inputPatternMatcher("KING, A1", INPUT_PATTERN), "Valid input with uppercase piece and position");
        assertTrue(inputParser.inputPatternMatcher("Queen, h8", INPUT_PATTERN), "Valid input with mixed case piece and position");
    }

    @Test
    void testInvalidInputs() {
        assertFalse(inputParser.inputPatternMatcher("rook z9", INPUT_PATTERN), "Invalid input without comma");
        assertFalse(inputParser.inputPatternMatcher("bishop,b0", INPUT_PATTERN), "Invalid input with out-of-range position");
        assertFalse(inputParser.inputPatternMatcher("knight, E10", INPUT_PATTERN), "Invalid input with position out of range");
        assertFalse(inputParser.inputPatternMatcher("kingG5", INPUT_PATTERN), "Invalid input without comma and space");
        assertFalse(inputParser.inputPatternMatcher("", INPUT_PATTERN),"Empty input");
        assertFalse(inputParser.inputPatternMatcher(null, INPUT_PATTERN), "Null input");
    }

    @Test
    void testEdgeCases() {
        assertFalse(inputParser.inputPatternMatcher("rook,", INPUT_PATTERN), "Invalid input with missing position");
        assertFalse(inputParser.inputPatternMatcher(", b4", INPUT_PATTERN), "Invalid input with missing piece");
        assertFalse(inputParser.inputPatternMatcher(" , ", INPUT_PATTERN), "Invalid input with only comma and spaces");
        assertTrue(inputParser.inputPatternMatcher("Pawn, a8", INPUT_PATTERN), "Valid input at board edge");
    }
}