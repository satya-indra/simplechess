package org.example.piece;

import org.example.board.Position;

import java.util.List;

import static org.example.constants.Constants.BOARD_SIZE;

public abstract class Piece {

    protected Character icon;
    protected abstract List<int[]> getAllowedOffsets();
    public abstract Character getIcon();
    public abstract List<Position> getAvailableMoves(Position currentPosition);
    // Check if a position is valid on the chessboard (1-8 for rows, A-H for columns)
    protected boolean isPositionValid(int row, int col) {
        return row >= 1 && row <= BOARD_SIZE && col >= 1 && col <= BOARD_SIZE;
    }

}
