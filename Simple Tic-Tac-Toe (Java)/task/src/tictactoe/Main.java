package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] grid = getGrid();
        printBoard(grid);
        String status = getState(grid);
        boolean xSign = true;

        while (status.equals("Game not finished")) {
            int[] move =  getInput();
            while (!checkInput(move, grid)) {
                move = getInput();
            }
            if (move != null) {
                int xCoord = move[0] - 1;
                int yCoord = move[1] - 1;
                grid[xCoord][yCoord] = xSign ? 'X' : 'O';
                xSign = !xSign;
            }
            printBoard(grid);
            status = getState(grid);
        }
        System.out.println(status);
    }

    public static  boolean checkInput(int[] move, char[][] grid) {
        if (move == null) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (move[0] < 1 || move[0] > 3 || move[1] < 1 || move[1] > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (grid[move[0] - 1][move[1] - 1] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    public static  int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates you want to play: ");
        if (scanner.hasNextInt()) {
            int xCoord = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int yCoord = scanner.nextInt();
                return new int[] {xCoord, yCoord};
            }
        }
        return null;
    }

    private static char[][] getGrid() {
        char[][] grid = new char[3][3];
        for (char[] line: grid) {
            Arrays.fill(line, ' ');
        }
        return grid;
    }

    private static void printBoard(char[][] grid) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |%n", grid[0][0], grid[0][1], grid[0][2]);
        System.out.printf("| %c %c %c |%n", grid[1][0], grid[1][1], grid[1][2]);
        System.out.printf("| %c %c %c |%n", grid[2][0], grid[2][1], grid[2][2]);
        System.out.println("---------");
    }

    private static String getState(char[][] grid) {
        int totalX = 0;
        int totalO = 0;
        for (char[] line : grid) {
            for (char symbol : line) {
                if (symbol == 'X') {
                    totalX++;
                } else if (symbol == 'O') {
                    totalO++;
                }
            }
        }
        int difference = totalO - totalX;
        if (difference < -1 || difference > 1) {
            return "Impossible";
        }
        boolean xWon = isSymbolWon(grid, 'X');
        boolean oWon = isSymbolWon(grid, 'O');
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
    private static boolean isSymbolWon(char[][] grid, char symbol) {
        return grid[0][0] == symbol && grid[0][1] == symbol && grid[0][2] == symbol
                || grid[1][0] == symbol && grid[1][1] == symbol && grid[1][2] == symbol
                || grid[2][0] == symbol && grid[2][1] == symbol && grid[2][2] == symbol
                || grid[0][0] == symbol && grid[1][0] == symbol && grid[2][0] == symbol
                || grid[0][1] == symbol && grid[1][1] == symbol && grid[2][1] == symbol
                || grid[0][2] == symbol && grid[1][2] == symbol && grid[2][2] == symbol
                || grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol
                || grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol;
    }
}
