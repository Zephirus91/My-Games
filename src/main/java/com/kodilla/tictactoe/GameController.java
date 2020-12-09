package com.kodilla.tictactoe;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class GameController {
    private Image letterX = new Image("file:src/main/resources/TicTacToe/xxx.png");
    private Image letterO = new Image("file:src/main/resources/TicTacToe/ooo.png");
    private GameLogic gameLogic;
    private GridPane grid;

    public GameController(GameLogic gameLogic, GridPane grid) {

        this.gameLogic = gameLogic;
        this.grid = grid;
    }

    public void click(int x, int y) {
        gameLogic.click(x,y);
    }

    public void showOnBoard() {
        grid.getChildren().clear();
        for (int row = 0; row<3; row++) {
            for (int col = 0; col < 3; col++) {
                String figure = gameLogic.getFigure(col, row);
                ImageView imageView = null;
                if (figure.equals("x")) {
                    imageView = new ImageView(letterX);

                } else if (figure.equals("o")) {
                    imageView = new ImageView(letterO);

                }
                if (imageView != null) {
                    grid.add(imageView, col, row);
                }
            }
        }
    }
}
