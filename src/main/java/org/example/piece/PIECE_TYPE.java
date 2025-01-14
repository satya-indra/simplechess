package org.example.piece;

public enum PIECE_TYPE {
    KING, QUEEN, PAWN;

    // Method to convert string to PIECE_TYPE enum (case-insensitive)
    public static PIECE_TYPE fromString(String input) {
        try {
            return PIECE_TYPE.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Handle invalid input (e.g., returning null or throwing an exception)
            System.out.println("Invalid piece type: " + input);
            return null;
        }
    }
}
