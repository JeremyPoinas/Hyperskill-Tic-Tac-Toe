package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char firstSymbol = input.charAt(0);
        char secondSymbol = input.charAt(1);
        char thirdSymbol = input.charAt(2);
        char fourthSymbol = input.charAt(3);
        char fifthSymbol = input.charAt(4);
        char sixthSymbol = input.charAt(5);
        char seventhSymbol = input.charAt(6);
        char eighthSymbol = input.charAt(7);
        char ninthSymbol = input.charAt(8);


        String grid = """
                ---------
                | %s %s %s |
                | %s %s %s |
                | %s %s %s |
                ---------
                """;
        System.out.printf(grid, firstSymbol, secondSymbol, thirdSymbol, fourthSymbol, fifthSymbol, sixthSymbol, seventhSymbol, eighthSymbol, ninthSymbol);
    }
}
