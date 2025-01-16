package org.example.io;


/**
 * Making game independent of how input and output is given.
 * For instance, a ConsoleGame might use standard input/output, while a WebGame would interact with HTTP requests/responses.
 */
public interface GameIO {
    String readInput(); // e.g., "KING, B4"
    void writeOutput(String output); // e.g., "Available Moves: A3, B3, C3"
}
