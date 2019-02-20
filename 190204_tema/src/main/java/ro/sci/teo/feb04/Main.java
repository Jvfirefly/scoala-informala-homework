package ro.sci.teo.feb04;

import java.util.Scanner;

/**
 * This is the main class, where the TicTacToe game can be played.
 *
 * @author Teo
 */

public class Main {
    private static TicTacToe game = new TicTacToe();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (!game.isWin() && !game.isDraw()) {
            game.setCurrentPlayer();
            boolean moveOk=false;
            do {
                System.out.print("Player " + game.getCurrentPlayer() + ", enter your move (row[1-3] column[1-3]): ");
                int row = sc.nextInt();
                int col = sc.nextInt();
                if (game.placeMove(row-1, col-1)) {
                    printBoard();
                    moveOk = true;
                } else {
                    System.out.println("This move at (" + row + "," + col + ") is not valid. Try again...");
                }
            } while (!moveOk);
        }

        if(game.isWin())
            System.out.println("Player '"+ game.getCurrentPlayer() +"' won!");
        else
            System.out.println("This game is a draw.");
    }

    /**
     * This method prints the updated board of the TicTacToe game.
     */
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + game.getBoard().get(i + "" + j) + " ");
                if (j < 2)
                    System.out.print("|");
            }
            if (i < 2)
                System.out.println("\n-----------");
        }
        System.out.println();
        System.out.println();
    }
}
