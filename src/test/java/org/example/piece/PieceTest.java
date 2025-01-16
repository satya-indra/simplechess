package org.example.piece;

import org.example.board.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
    private Piece piece;

    @BeforeEach
    void setUp() {
        piece = new King(); // Only for king, similar way we can do it for other piece
    }

    @Test
    void testGetAvailableMoves_NullPosition() {
        List<Position> moves = piece.getAvailableMoves(null);
        assertTrue(moves.isEmpty(), "Moves should be empty when input position is null");
    }

    @Test
    void testGetAvailableMoves_ValidPosition() {
        Position startPosition = new Position(4, 4); // Center of the board
        List<Position> moves = piece.getAvailableMoves(startPosition);

        assertEquals(8, moves.size(), "King should have 8 possible moves from the center");
        assertTrue(moves.contains(new Position(3, 3)));
        assertTrue(moves.contains(new Position(3, 4)));
        assertTrue(moves.contains(new Position(3, 5)));
        assertTrue(moves.contains(new Position(4, 3)));
        assertTrue(moves.contains(new Position(4, 5)));
        assertTrue(moves.contains(new Position(5, 3)));
        assertTrue(moves.contains(new Position(5, 4)));
        assertTrue(moves.contains(new Position(5, 5)));
    }

    @Test
    void testGetAvailableMoves_EdgePosition() {
        Position startPosition = new Position(1, 1); // Bottom-left corner of the board
        List<Position> moves = piece.getAvailableMoves(startPosition);

        assertEquals(3, moves.size(), "King should have 3 possible moves from the corner");
        assertTrue(moves.contains(new Position(1, 2)));
        assertTrue(moves.contains(new Position(2, 1)));
        assertTrue(moves.contains(new Position(2, 2)));
    }

    @Test
    void testGetAvailableMoves_OutOfBounds() {
        Position startPosition = new Position(8, 8); // Top-right corner of the board
        List<Position> moves = piece.getAvailableMoves(startPosition);

        assertEquals(3, moves.size(), "King should have 3 possible moves from the top-right corner");
        assertTrue(moves.contains(new Position(7, 8)));
        assertTrue(moves.contains(new Position(7, 7)));
        assertTrue(moves.contains(new Position(8, 7)));
    }

    @Test
    void testGetAvailableMoves_InvalidPositionsFiltered() {
        Position startPosition = new Position(4, 4); // Center of the board

        // Mock or stub `isPositionValid` to make specific positions invalid
        piece = new King() {
            @Override
            protected boolean isPositionValid(int row, int col) {
                return !(row == 3 && col == 3); // Mock (3, 3) as invalid
            }
        };

        List<Position> moves = piece.getAvailableMoves(startPosition);
        assertEquals(7, moves.size(), "One move should be filtered out as invalid");
        assertFalse(moves.contains(new Position(3, 3)), "Move to (3, 3) should not be in the result");
    }

}
