package org.example.utils;

import org.example.board.Position;
import org.example.piece.PIECE_TYPE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ChessUtilsTest {
    private ChessUtils chessUtils;

    @BeforeEach
    void setup() {
        this.chessUtils = new StandardConsoleChessUtils();
    }

    @Test
    void testToPieceType_ValidPieceName() {
        Optional<PIECE_TYPE> pieceType = chessUtils.toPieceType("KING");
        assertTrue(pieceType.isPresent(), "KING should be a valid piece type");
        assertEquals(PIECE_TYPE.KING, pieceType.get());
    }

    @Test
    void testToPieceType_InvalidPieceName() {
        Optional<PIECE_TYPE> pieceType = chessUtils.toPieceType("INVALID");
        assertFalse(pieceType.isPresent(), "Invalid piece name should return empty");
    }

    @Test
    void testToPieceType_NullPieceName() {
        Optional<PIECE_TYPE> pieceType = chessUtils.toPieceType(null);
        assertFalse(pieceType.isPresent(), "Null piece name should return empty");
    }

    @Test
    void testToPieceType_EmptyPieceName() {
        Optional<PIECE_TYPE> pieceType = chessUtils.toPieceType("");
        assertFalse(pieceType.isPresent(), "Empty piece name should return empty");
    }

    @Test
    void testToPosition_ValidPosition() {
        Optional<Position> position = chessUtils.toPosition("D5");
        assertTrue(position.isPresent(), "D5 should be a valid position");
        assertEquals(new Position(5, 4), position.get()); // Column 'D' is 4, Row '5' is 5
    }

    @Test
    void testToPosition_EmptyInput() {
        Optional<Position> position = chessUtils.toPosition("  ");
        assertFalse(position.isPresent(), "Blank position should return empty");
    }

    @Test
    void testToPosition_OutOfBounds() {
        Optional<Position> position = chessUtils.toPosition("Z9"); // Assume board is 8x8
        assertFalse(position.isPresent(), "Out-of-bounds position should return empty");
    }

    @Test
    void testToPosition_NullInput() {
        Optional<Position> position = chessUtils.toPosition(null);
        assertFalse(position.isPresent(), "Null input should return empty");
    }

    @Test
    void testToString_ValidPosition() {
        Optional<String> positionString = chessUtils.toString(new Position(5, 4)); // Row 5, Column 'D'
        assertTrue(positionString.isPresent(), "Valid position object should return non-empty string");
        assertEquals("D5", positionString.get());
    }

    @Test
    void testToString_InvalidRow() {
        Optional<String> positionString = chessUtils.toString(new Position(9, 4)); // Assume max row is 8
        assertFalse(positionString.isPresent(), "Invalid row should return empty");
    }

    @Test
    void testToString_InvalidColumn() {
        Optional<String> positionString = chessUtils.toString(new Position(5, 9)); // Assume max column is 8
        assertFalse(positionString.isPresent(), "Invalid column should return empty");
    }

    @Test
    void testToString_NullPosition() {
        Optional<String> positionString = chessUtils.toString(null);
        assertFalse(positionString.isPresent(), "Null position should return empty");
    }

}
