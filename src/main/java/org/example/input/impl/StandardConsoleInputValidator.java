package org.example.input.impl;

import org.example.board.Position;
import org.example.input.InputValidator;
import org.example.input.UserInput;
import org.example.piece.PIECE_TYPE;
import org.example.tranformer.TransformerFactory;

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

        return Optional.of(new UserInput(pieceTypeOptional.get(), positionOptional.get()));
    }
}
