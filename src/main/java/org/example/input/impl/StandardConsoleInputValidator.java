package org.example.input.impl;

import org.example.board.Position;
import org.example.input.InputValidator;
import org.example.dto.UserInput;
import org.example.factory.UserInputFactory;
import org.example.piece.PIECE_TYPE;
import org.example.factory.TransformerFactory;

import java.util.Optional;

public class StandardConsoleInputValidator implements InputValidator {

    @Override
    public Optional<UserInput> validate(String input) {

        String[] splitInput = input.split(",");
        String piece = splitInput[0];
        String pos = splitInput[1];

        Optional<PIECE_TYPE> pieceTypeOptional = TransformerFactory.getTransformer().toPieceType(piece);
        if (pieceTypeOptional.isEmpty()) {
            System.out.println("Invalid piece name input. Correct input example: king, b4");
            return Optional.empty();
        }

        Optional<Position> positionOptional = TransformerFactory.getTransformer().toPosition(pos);
        if (positionOptional.isEmpty()) {
            System.out.println("Invalid position input. Correct input example: king, b4");
            return Optional.empty();
        }

        UserInput userInput = UserInputFactory.getInputInstance();

        userInput.setPiece(pieceTypeOptional.get());
        userInput.setPosition(positionOptional.get());


        return Optional.of(userInput);
    }
}
