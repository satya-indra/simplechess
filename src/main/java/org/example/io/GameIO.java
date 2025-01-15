package org.example.io;

public interface GameIO {
    String readInput(); // e.g., "KING, B4"
    void writeOutput(String output); // e.g., "Available Moves: A3, B3, C3"
}
