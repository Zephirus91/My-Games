package com.kodilla.tictactoe;

public class GameLogic {

    private String[][] gBoard;
    private String whoseMove = "x";

    public GameLogic() {
        gBoard = new String[3][];
        for (int n = 0; n < 3; n++)
            gBoard[n] = new String[3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                gBoard[col][row] = " ";
    }

    public void click(int col, int row) {
        if (gBoard[col][row].equals(" ")) {
            setFigure(col, row, whoseMove);
            whoseMove = getOpposite(whoseMove);
        }
    }

    private String getOpposite(String whoseMove) {
        return (whoseMove.equals("x")) ? "o" : "x";
    }

    public String getFigure(int col, int row) {
        return gBoard[col][row];
    }

    public void setFigure(int col, int row, String figure) {
        gBoard[col][row] = figure;
    }

    public String checkWinner() {
        String result = checkWinnerForRows();
        if (result.equals(" "))
            result = checkWinnerForCols();
        if (result.equals(" "))
            result = checkWinnerForDiagonals();
        return result;
    }

    private String checkWinnerForRows() {
        String result = " ";
        for (int row = 0; row<3; row++) {
            if (result.equals(" ")) {
                if (gBoard[0][row].equals("x") && gBoard[1][row].equals("x") && gBoard[2][row].equals("x"))
                    result = "x";
                if (gBoard[0][row].equals("o") && gBoard[1][row].equals("o") && gBoard[2][row].equals("o"))
                    result = "o";
            }
        }
        return result;
    }

    private String checkWinnerForCols() {
        String result = " ";
        for (int col = 0; col<3; col++) {
            if (result.equals(" ")) {
                if (gBoard[col][0].equals("x") && gBoard[col][1].equals("x") && gBoard[col][2].equals("x"))
                    result = "x";
                if (gBoard[col][0].equals("o") && gBoard[col][1].equals("o") && gBoard[col][2].equals("o"))
                    result = "o";
            }
        }
        return result;
    }

    private String checkWinnerForDiagonals() {
        String result = " ";
        if (gBoard[0][0].equals("x") && gBoard[1][1].equals("x") && gBoard[2][2].equals("x"))
            result = "x";
        if (gBoard[0][0].equals("o") && gBoard[1][1].equals("o") && gBoard[2][2].equals("o"))
            result = "o";
        if (gBoard[2][0].equals("x") && gBoard[1][1].equals("x") && gBoard[0][2].equals("x"))
            result = "x";
        if (gBoard[2][0].equals("o") && gBoard[1][1].equals("o") && gBoard[0][2].equals("o"))
            result = "o";

        return result;
    }
}
