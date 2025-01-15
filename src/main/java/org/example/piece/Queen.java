package org.example.piece;

import org.example.board.Position;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Queen extends Piece {
    public Queen() {
        this.icon = 'Q';
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

    @Override
    public List<Position> getAvailableMoves(Position currentPosition) {
        List<Position> availableMoves = new ArrayList<>();
        if (currentPosition == null) {
            return availableMoves; // No moves possible if input is null
        }

        // Explore each direction
        for (int[] offset : getAllowedOffsets()) {
            int row = currentPosition.row();
            int col = currentPosition.col();

            // Move in the direction of the offset
            while (true) {
                row += offset[0];
                col += offset[1];

                // Break if out of bounds
                if (!isPositionValid(row, col)) break;

                // Add the new position
                availableMoves.add(new Position(row, col));
            }
        }

        return availableMoves;
    }

}
