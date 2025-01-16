package org.example.game;

import org.example.board.Board;
import org.example.board.Position;
import org.example.input.InputParser;
import org.example.dto.UserInput;
import org.example.factory.InputParserFactory;
import org.example.io.GameIO;
import org.example.piece.Piece;
import org.example.factory.PieceFactory;
import org.example.factory.TransformerFactory;

import java.util.List;
import java.util.Optional;

public class StandardConsoleGame extends AbstractGame {

    public StandardConsoleGame(Board board, GameIO gameIO) {
        this.board = board;
        this.gameIO = gameIO;
    }

    public void play() {

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
                gameIO.writeOutput("No Input found.");
                continue;
            }

            Piece piece = PieceFactory.getPiece(userInput.get().getPiece());

            List<Position> availableMoves = piece.getAvailableMoves(userInput.get().getPosition());

            board.addAvailableMoves(availableMoves, piece);

            board.displayBoard();

            if (availableMoves.isEmpty()) {
                gameIO.writeOutput("No moves found");
            }

            availableMoves.forEach(pos -> System.out.print(TransformerFactory.getTransformer().toString(pos).get() + ", "));

            board.reset();

        }


    }


}
