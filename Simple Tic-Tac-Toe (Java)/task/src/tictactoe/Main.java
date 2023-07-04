package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] input = getInput();
        printBoard(input);
        System.out.println(getState(input));
    }

    private static char[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        return scanner.nextLine().toCharArray();
    }

    private static void printBoard(char[] input) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |%n", input[0], input[1], input[2]);
        System.out.printf("| %c %c %c |%n", input[3], input[4], input[5]);
        System.out.printf("| %c %c %c |%n", input[6], input[7], input[8]);
        System.out.println("---------");
    }

    private static String getState(char[] input) {
        int totalX = 0;
        int totalO = 0;
        for (char symbol : input) {
            if (symbol == 'X') {
                totalX++;
            } else if (symbol == 'O') {
                totalO++;
            }
        }
        int difference = totalO - totalX;
        if (difference < -1 || difference > 1) {
            return "Impossible";
        }
        boolean xWon = isSymbolWon(input, 'X');
        boolean oWon = isSymbolWon(input, 'O');
        if (xWon && oWon) {
            return "Impossible";
        }
        if (xWon) {
            return "X wins";
        }
        if (oWon) {
            return "O wins";
        }
        if (totalO + totalX == 9) {
            return "Draw";
        }
        return "Game not finished";
    }
    private static boolean isSymbolWon(char[] input, char symbol) {
        return input[0] == symbol && input[1] == symbol && input[2] == symbol
                || input[3] == symbol && input[4] == symbol && input[5] == symbol
                || input[6] == symbol && input[7] == symbol && input[8] == symbol
                || input[0] == symbol && input[3] == symbol && input[6] == symbol
                || input[1] == symbol && input[4] == symbol && input[7] == symbol
                || input[2] == symbol && input[5] == symbol && input[8] == symbol
                || input[0] == symbol && input[4] == symbol && input[8] == symbol
                || input[2] == symbol && input[4] == symbol && input[6] == symbol;
    }
}
