package org.example.game;

import org.example.board.Board;
import org.example.board.EmptyBoard;
import org.example.board.Position;
import org.example.input.InputParser;
import org.example.input.UserInput;
import org.example.input.factory.InputParserFactory;
import org.example.io.GameIO;
import org.example.piece.Piece;
import org.example.piece.PieceFactory;
import org.example.tranformer.TransformerFactory;

import java.util.List;
import java.util.Optional;

public class SimpleConsoleGame extends Game {

    public SimpleConsoleGame(Board board, GameIO gameIO) {
        this.board = board;
        this.gameIO = gameIO;
    }

    public Board play() {

        while (true) {
            gameIO.writeOutput("Welcome to the game");

            gameIO.writeOutput("Enter your move. Example KING, B4");

            gameIO.writeOutput("Type exit to end the game");

            String consoleInput = gameIO.readInput();

            if ("EXIT".equalsIgnoreCase(consoleInput)) {
                gameIO.writeOutput("Game ended. Thanks for Playing.");
                break;
            }

            InputParser parser = InputParserFactory.getInputParser();

            Optional<UserInput> userInput = parser.parse(consoleInput);

            if (userInput.isEmpty()) {
                continue;
            }

            Piece piece = PieceFactory.getPiece(userInput.get().piece());

            List<Position> availableMoves = piece.getAvailableMoves(userInput.get().position());

            board.addAvailableMoves(availableMoves, piece);

            board.displayBoard();

            if (availableMoves.isEmpty()) {
                System.out.println("No moves found");
            }

            availableMoves.forEach(pos -> System.out.print(TransformerFactory.getTransformer().toString(pos).get() + ", "));

            board.reset();

        }


        return board;

    }


}
