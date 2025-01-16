package org.example.input;

import org.example.dto.UserInput;

import java.util.Optional;

public interface InputValidator {
    Optional<UserInput> validate(String userInput);
}
