package org.example.game;

import org.example.board.Board;
import org.example.board.Position;
import org.example.constants.Constants;
import org.example.input.InputParser;
import org.example.dto.UserInput;
import org.example.factory.InputParserFactory;
import org.example.io.GameIO;
import org.example.piece.PIECE_TYPE;
import org.example.piece.Piece;
import org.example.factory.PieceFactory;
import org.example.factory.TransformerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StandardConsoleGame extends AbstractGame {

    public StandardConsoleGame(Board board, GameIO gameIO) {
        this.board = board;
        this.gameIO = gameIO;
    }

    public void play() {
        System.out.println("--------------------");
        gameIO.writeOutput("WELCOME TO SIMPLE CHESS GAME. FIND ALL THE MOVES YOUR PIECE CAN PLAY.");
        while (true) {
            printGameInstructions();

            String consoleInput = gameIO.readInput();

            if (endTheGame(consoleInput)) {
                gameIO.writeOutput("Game ended. Thanks for Playing.");
                break;
            }

            Optional<UserInput> userInput = parseAndValidateInput(consoleInput);

            if (userInput.isEmpty()) {
                gameIO.writeOutput("No Input OR Invalid Input. Please re enter the correct input." +
                        "Allowed Piece are : " + Arrays.toString(PIECE_TYPE.values()));
                continue;
            }

            Piece piece = PieceFactory.getPiece(userInput.get().getPiece());

            List<Position> availableMoves = piece.getAvailableMoves(userInput.get().getPosition());

            board.addAvailableMoves(availableMoves, piece);

            board.displayBoard();

            if (availableMoves.isEmpty()) {
                gameIO.writeOutput("No moves found");
            }

            displayAllPossibleMoves(availableMoves);

            // It's a simple game, where state is not saved.
            board.reset();

        }

    }

    private static void displayAllPossibleMoves(List<Position> availableMoves) {
        System.out.println("--------------------");

        String str = availableMoves.stream().map(ele -> TransformerFactory.getTransformer(Constants.APP_TYPE).toString(ele).get()).collect(Collectors.joining(", "));

        System.out.println(str);
    }

    private static Optional<UserInput> parseAndValidateInput(String consoleInput) {
        InputParser parser = InputParserFactory.getInputParser(Constants.APP_TYPE);
        return parser.parse(consoleInput);
    }

    private static boolean endTheGame(String consoleInput) {
        return Constants.CONSOLE_EXIT_INPUT.equalsIgnoreCase(consoleInput);
    }

    private void printGameInstructions() {
        System.out.println("--------------------");
        gameIO.writeOutput("TYPE EXIT TO END THE GAME.");
        gameIO.writeOutput("ENTER YOUR MOVE IN FORMAT : <PIECE NAME, POSITION<COLUMN, ROW>> KING, A1. A1 MEANS 1ST COLUMN 1ST ROW");
        System.out.println("--------------------");
    }


}
