package org.example.input;

import org.example.input.impl.StandardConsoleInputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidatorTest {
    private final InputValidator inputValidator = new StandardConsoleInputValidator();

    @Test
    public void basicValidInputs() {
        assertTrue(inputValidator.validate("king, b4").isPresent(), "Valid input with lowercase piece and position");
    }

    @Test
    public void basicInValidInputs() {
        assertTrue(inputValidator.validate("kin, b4").isEmpty(), "InValid input with invalid piece");
    }

}
