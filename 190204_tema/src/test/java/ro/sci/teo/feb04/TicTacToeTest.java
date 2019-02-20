package ro.sci.teo.feb04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TicTacToeTest {

    private TicTacToe gameTest;

    @BeforeEach
    void initialize(){
        gameTest = new TicTacToe();
    }

    @Test
    void isDrawTrue() {
        for (String cell : gameTest.getBoard().keySet())
            gameTest.getBoard().put(cell,'*');
        Assertions.assertTrue(gameTest.isDraw());
    }

    @Test
    void isDrawFalseEmptyBoard() {
        Assertions.assertFalse(gameTest.isDraw());
    }

    @Test
    void isDrawFalseBoardPartiallyFull() {
        gameTest.getBoard().put("00",'*');
        gameTest.getBoard().put("01",'*');
        gameTest.getBoard().put("10",'*');
        gameTest.getBoard().put("11",'*');
        Assertions.assertFalse(gameTest.isDraw());
    }

    @Test
    void isWinTrueRow() {
        gameTest.getBoard().put("00",'*');
        gameTest.getBoard().put("01",'*');
        gameTest.getBoard().put("02",'*');
        Assertions.assertTrue(gameTest.isWin());
    }

    @Test
    void isWinFalseRow() {
        gameTest.getBoard().put("00",'*');
        gameTest.getBoard().put("01",'*');
        Assertions.assertFalse(gameTest.isWin());
    }

    @Test
    void isWinTrueCol() {
        gameTest.getBoard().put("00",'*');
        gameTest.getBoard().put("10",'*');
        gameTest.getBoard().put("20",'*');
        Assertions.assertTrue(gameTest.isWin());
    }

    @Test
    void isWinFalseCol() {
        gameTest.getBoard().put("00",'*');
        gameTest.getBoard().put("10",'*');
        gameTest.getBoard().put("22",'*');
        Assertions.assertFalse(gameTest.isWin());
    }

    @Test
    void isWinTrueDiag() {
        gameTest.getBoard().put("00",'*');
        gameTest.getBoard().put("11",'*');
        gameTest.getBoard().put("22",'*');
        Assertions.assertTrue(gameTest.isWin());
    }

    @Test
    void isWinFalseDiag() {
        gameTest.getBoard().put("00",'*');
        gameTest.getBoard().put("01",'*');
        gameTest.getBoard().put("22",'*');
        Assertions.assertFalse(gameTest.isWin());
    }

    @Test
    void checkRowsTrue() {
        gameTest.getBoard().put("10",'*');
        gameTest.getBoard().put("11",'*');
        gameTest.getBoard().put("12",'*');
        Assertions.assertTrue(gameTest.checkRows());
    }

    @Test
    void checkRowsFalse() {
        gameTest.getBoard().put("10",'*');
        gameTest.getBoard().put("11",'*');
        gameTest.getBoard().put("12",'!');
        Assertions.assertFalse(gameTest.checkRows());
    }

    @Test
    void checkColsTrue() {
        gameTest.getBoard().put("01",'*');
        gameTest.getBoard().put("11",'*');
        gameTest.getBoard().put("21",'*');
        Assertions.assertTrue(gameTest.checkCols());
    }

    @Test
    void checkColsFalse() {
        gameTest.getBoard().put("01",'!');
        gameTest.getBoard().put("11",'*');
        gameTest.getBoard().put("21",'!');
        Assertions.assertFalse(gameTest.checkCols());
    }

    @Test
    void checkDiagsTrue() {
        gameTest.getBoard().put("00",'*');
        gameTest.getBoard().put("11",'*');
        gameTest.getBoard().put("22",'*');
        Assertions.assertTrue(gameTest.checkDiags());
    }

    @Test
    void checkDiagsFalse() {
        gameTest.getBoard().put("00",'*');
        gameTest.getBoard().put("11",'*');
        Assertions.assertFalse(gameTest.checkDiags());
    }

    @Test
    void isAlikeTrue() {
        char a='a';
        char b='a';
        char c='a';
        Assertions.assertTrue(gameTest.isAlike(a,b,c));
    }

    @Test
    void isAlikeFalseDifferentValues() {
        char a='a';
        char b='b';
        char c='a';
        Assertions.assertFalse(gameTest.isAlike(a,b,c));
    }

    @Test
    void isAlikeFalseSpaceChar() {
        char a='a';
        char b='b';
        char c=' ';
        Assertions.assertFalse(gameTest.isAlike(a,b,c));
    }

    @Test
    void placeMoveTrue() {
        Assertions.assertTrue(gameTest.placeMove(0,0));
    }

    @Test
    void placeMoveFalseSpotNotEmpty() {
        gameTest.getBoard().put("00",'*');
        Assertions.assertFalse(gameTest.placeMove(0,0));
    }

    @Test
    void placeMoveFalseRowTooSmall() {
        Assertions.assertFalse(gameTest.placeMove(-1,0));
    }

    @Test
    void placeMoveFalseRowTooBig() {
        Assertions.assertFalse(gameTest.placeMove(3,0));
    }

    @Test
    void placeMoveFalseColTooSmall() {
        Assertions.assertFalse(gameTest.placeMove(0,-1));
    }

    @Test
    void placeMoveFalseColTooBig() {
        Assertions.assertFalse(gameTest.placeMove(0,3));
    }
}