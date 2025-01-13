package org.example;

import java.util.Scanner;

public class ChessApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to simple chess");
        System.out.println("Type exit to end the game");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Enter your move. Example KING, B4");

            String consoleInput = scanner.nextLine();

            if ("EXIT".equalsIgnoreCase(consoleInput.toUpperCase())) {
                System.out.println("Game ended. Thanks for Playing.");
                break;
            }

        }

    }
}