package org.example.board;

public record Position(int row, int col) {
    public Position move(int rowOffset, int colOffset) {
        return new Position(this.row + rowOffset, this.col + colOffset);
    }

}
