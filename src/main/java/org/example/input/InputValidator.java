package org.example.input;

import java.util.Optional;

public interface InputValidator {
    Optional<UserInput> validate(String userInput);
}
