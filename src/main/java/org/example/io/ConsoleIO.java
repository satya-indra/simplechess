package org.example.io;

import java.util.Scanner;

public class ConsoleIO implements GameIO {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readInput() {
        return scanner.nextLine();
    }

    @Override
    public void writeOutput(String output) {
        System.out.println(output);
    }

}
