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
}
