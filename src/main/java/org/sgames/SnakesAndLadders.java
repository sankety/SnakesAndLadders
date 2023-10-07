package org.sgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SnakesAndLadders {
    private int playerA = 0;
    private int playerB = 0;
    private int diceNumber = 1;
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    Board board;

    public SnakesAndLadders() {
        board = new Board();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Snakes and ladder! 🐍🪜 \n To see the board type b \n To exit the game type exit ");
        System.out.println("You will be player A (RED) 🔴");
        boolean complete = false;
        do {
            System.out.println(ANSI_RED + "Its your turn, would you like to roll the dice? type yes or y" + ANSI_RESET);
            String response = input.next();
            if (response.equalsIgnoreCase("b")) {
                displayBoard();
                continue;
            }
            if (response.equalsIgnoreCase("exit")) {
                complete = true;
                System.out.println("Its sad to see you go ! Bye 👋");
                continue;
            }
            playersTurn(response);
            System.out.println("🔷🔷🔷🔷🔷🔷🔷🔷🔷");
            computersTurn();
            if (playerA == 100 || playerB == 100) {
                complete = true;
                displayBoard();
                System.out.println(playerA == 100 ? "Player A is winner 👑" : "Computer is the winner 👑");
            }
        } while (!complete);
    }

    private void playersTurn(String a) {
        if (a.equalsIgnoreCase("yes") || a.equalsIgnoreCase("y")) {
            rollDice();
            System.out.println(ANSI_RED + "You rolled a " + diceNumber);
            System.out.println(ANSI_RED + "Moving " + diceNumber + " steps" + ANSI_RESET);
            playerA = playerA + diceNumber;
            if (playerA > 100) {
                playerA = 100;
            }
            playerA = board.validate(playerA);
            if (diceNumber == 6) {
                System.out.println(ANSI_RED + "You rolled a " + diceNumber + " so you get another turn ");
                playersTurn("yes");
            }
        }
    }

    private void computersTurn() {
        System.out.println(ANSI_GREEN + "Computer is rolling the dice 🎲 ..." + ANSI_RESET);
        rollDice();
        System.out.println(ANSI_GREEN + "Computer rolled a " + diceNumber + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Moving " + diceNumber + " steps for Computer" + ANSI_RESET);
        playerB = playerB + diceNumber;
        if (playerB > 100) {
            playerB = 100;
        }
        playerB = board.validate(playerB);
        if (diceNumber == 6) {
            System.out.println(ANSI_RED + "Computer rolled a " + diceNumber + " so it gets another turn ");
            computersTurn();
        }
    }

    private void displayBoard() {
        List<Integer> tenList = new ArrayList<>();
        int num = 100;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tenList.add(num - j);
            }
            if (i % 2 != 0) {
                Collections.reverse(tenList);
            }
            tenList.forEach(inner -> {
                if (inner == playerA) {
                    System.out.print(ANSI_RED + inner + " " + ANSI_RESET);
                } else if (inner == playerB) {
                    System.out.print(ANSI_GREEN + inner + " " + ANSI_RESET);
                } else {
                    System.out.print(inner + " ");
                }
            });
            tenList.clear();
            num = num - 10;

            System.out.println("\n");
            if (num <= 1) {
                break;
            }
        }
    }

    private void rollDice() {
        int min = 1;
        int max = 7;
        diceNumber = (int) ((Math.random() * (max - min)) + min);
        diceNumber = Math.min(diceNumber, 6);
    }
}
