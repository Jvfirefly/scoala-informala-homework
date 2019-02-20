package ro.sci.teo.feb04;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a TicTacToe game.
 *
 * @author Teo
 */

public class TicTacToe {

    private Map<String, Character> board;
    private char currentPlayer;

    public TicTacToe() {
        this.board = new HashMap<>();
        this.currentPlayer = 'O';
        setUpBoard();
    }

    /**
     * This method switches between players.
     */
    public void setCurrentPlayer() {
        if (this.currentPlayer == 'X')
            this.currentPlayer= 'O';
        else
            this.currentPlayer='X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * This method is only used once, when a TicTacToe object is being instantiated.
     * It is meant to prepare the board for the game.
     */
    public void setUpBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board.put(i + "" + j, ' ');
    }

    public Map<String, Character> getBoard() {
        return board;
    }

    /**
     * The method checks if the game ended indecisively (the board is full), in which case it returns true.
     * <p>
     * If the board is not full yet, it means that there still can be a winner, so the method returns false.
     * In case one of the two players wins with its last game move, the method isWin() recognizes this.
     *
     * @see public boolean isWin() {...}
     * @return true or false
     */
    public boolean isDraw() {
        boolean full = true;
        for (String cell : board.keySet())
                if (board.get(cell) == ' ')
                    full = false;
        return full;
    }

    /**
     * This method checks if there is a winner, in which case it returns true.
     * <p>
     * It uses three other methods to check for win. The methods' names are self explanatory.
     *
     * @return true or false
     */
    public boolean isWin() {
        return checkRows() || checkCols() || checkDiags();
    }

    /**
     * This method checks if there are three equal marks in one row, case in which it returns true.
     *
     * @return true or false
     */
    public boolean checkRows() {
        for (int i = 0; i < 3; i++)
            if (isAlike(board.get(i + "0"), board.get(i + "1"), board.get(i + "2")))
                return true;
        return false;
    }

    /**
     * This method checks if there are three equal marks in one line, case in which it returns true.
     *
     * @return true or false
     */
    public boolean checkCols() {
        for (int j = 0; j < 3; j++)
            if (isAlike(board.get("0" + j), board.get("1" + j), board.get("2" + j)))
                return true;
        return false;
    }

    /**
     * This method checks if there are three equal marks on one of the two diagonals, case in which it returns true.
     *
     * @return true or false
     */
    public boolean checkDiags() {
        return isAlike(board.get("00"), board.get("11"), board.get("22")) ||
                isAlike(board.get("02"), board.get("11"), board.get("20"));
    }

    /**
     * This method checks if three char values are similar, but different from ' '.
     * If so, it returns true, otherwise false.
     *
     * @param a first char value
     * @param b second char value
     * @param c third char value
     * @return true or false
     */
    public boolean isAlike(char a, char b, char c) {
        return ((a != ' ') && (a == b) && (b == c));
    }

    /**
     * This method checks if it is possible to place a move at a given spot, specified by the row and the column.
     * If yes, it puts the mark of the current player in that place and returns true, else it returns false.
     *<p>
     * In case the method returns false, it could either mean that the spot isn't empty (there has already been placed
     * a mark), or the given row or column is out of the board's grid.
     *
     * @param row int value representing the board row
     * @param col int value representing the board column
     * @return true or false
     */
    public boolean placeMove(int row, int col) {
        if ((row >= 0) && (row < 3))
            if ((col >= 0) && (col < 3))
                if (board.get(row + "" + col) == ' ') {
                    board.put(row + "" + col,this.currentPlayer);
                    return true;
                }
        return false;
    }

}
