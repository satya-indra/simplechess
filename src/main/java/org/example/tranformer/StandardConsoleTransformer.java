package org.example.tranformer;

import org.example.board.Position;
import org.example.piece.PIECE_TYPE;
import org.example.utils.StringUtils;

import java.util.Optional;

public class StandardConsoleTransformer implements Transformer {
    @Override
    public Optional<PIECE_TYPE> toPieceType(String pieceName) {

        try {
            PIECE_TYPE pieceType = PIECE_TYPE.fromString(pieceName);
            return pieceType != null ? Optional.of(pieceType) : Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    @Override
    public Optional<Position> toPosition(String positionName) {

        if (StringUtils.isBlank(positionName) || positionName.trim().length() != 2) {
            throw new IllegalArgumentException("Invalid position format.");
        }

        String trimmedPos = positionName.trim();

        char colChar = trimmedPos.toUpperCase().charAt(0);
        char rowChar = trimmedPos.charAt(1);

        int col = colChar - 'A' + 1;
        int row = rowChar - '0';

        if (!isRowValid(row) || !isColumnValid(col)) {
            System.out.println("Invalid position input.");
            return Optional.empty();
        }

        return Optional.of(new Position(row, col));

    }

    @Override
    public Optional<String> toString(Position position) {
        if (position == null) {
            return Optional.empty();
        }

        int row = position.row();
        int col = position.col();

        if (!isRowValid(row) || !isColumnValid(col)) {
            System.out.println("Invalid position object.");
            return Optional.empty();
        }

        char colChar = (char) ('A' + col - 1); // Convert column number to letter
        String positionName = String.valueOf(colChar) + row; // Combine column letter and row number

        return Optional.of(positionName);

    }

    private boolean isColumnValid(int col) {
        return isPositionIndexValid(col);
    }

    private static boolean isRowValid(int row) {
        return isPositionIndexValid(row);
    }

    private static boolean isPositionIndexValid(int pos) {
        return pos > 0 && pos < 9;
    }

}
