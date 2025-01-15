package org.example.piece;

import org.example.board.Board;
import org.example.board.Position;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.example.constants.Constants.BOARD_SIZE;

public class King extends Piece {
    public King() {
        this.icon = 'K';
    }

    @Override
    public List<int[]> getAllowedOffsets() {
        return asList(
                new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1},
                new int[]{0, -1},               new int[]{0, 1},
                new int[]{1, -1}, new int[]{1, 0}, new int[]{1, 1}
        );
    }

    public Character getIcon() {
        return this.icon;
    }

    public List<Position> getAvailableMoves(Position position) {
        List<Position> availableMoves = new ArrayList<>();
        if (position == null) {
            return availableMoves; // No moves possible if input is null
        }

        // Get movement offsets from the piece's type
        List<int[]> movementOffsets = getAllowedOffsets();
        for (int[] offset : movementOffsets) {
            int newRow = position.row() + offset[0];
            int newCol = position.col() + offset[1];

            // Check if the new position is within bounds and not occupied by a piece of the same side
            if (isPositionValid(newRow, newCol)) {
                availableMoves.add(new Position(newRow, newCol));
            }
        }
        return availableMoves;
    }

}
