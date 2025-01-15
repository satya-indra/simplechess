package org.example.board;

import org.example.constants.Constants;
import org.example.piece.Piece;

import java.util.List;

public class EmptyBoard extends AbstractBoard {

    @Override
    public void initialize() {
        super.reset();
    }


    /**
     * Adds the available moves for a given piece to the board.
     *
     * @param piece    The chess piece.
     * @param position The current position of the piece.
     */
    public void addAvailableMoves(List<Position> availableMoves, Piece piece) {

        // Mark the piece's current position
//        board[position.row()][position.col()] = 'P';

        // Mark all available moves on the board
        for (Position move : availableMoves) {
            board[move.row() - 1][move.col() - 1] = piece;
        }
    }

    /**
     * Displays the current state of the board in a grid format with row and column labels.
     */
    /**
     * Displays the current state of the board in a grid format with proper alignment.
     */
    public void displayBoard() {
        // Print column headers
        System.out.print("   ");
        for (int col = 0; col < Constants.BOARD_SIZE; col++) {
            System.out.printf(" %c  ", 'A' + col); // Column headers (A, B, C, ...)
        }
        System.out.println();
        System.out.print("  ");
        System.out.println("+" + "---+".repeat(Constants.BOARD_SIZE));

        // Print rows with row numbers and cell contents
        for (int row = Constants.BOARD_SIZE - 1; row >= 0; row--) {
            System.out.printf("%d |", row + 1); // Row numbers (8 to 1)
            for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                if (board[row][col] == null) {
                    // Empty cell represented by X
                    System.out.print(" * |");
                } else {
                    // Display the piece icon
                    Piece piece = board[row][col];
                    System.out.printf(" %s |", piece.getIcon());
                }
            }
            System.out.println(" " + (row + 1)); // Repeat row number at the end
            System.out.print("  ");
            System.out.println("+" + "---+".repeat(Constants.BOARD_SIZE));
        }

        // Print column headers again for bottom alignment
        System.out.print("   ");
        for (int col = 0; col < Constants.BOARD_SIZE; col++) {
            System.out.printf(" %c  ", 'A' + col); // Column headers (A, B, C, ...)
        }
        System.out.println();
    }


}
