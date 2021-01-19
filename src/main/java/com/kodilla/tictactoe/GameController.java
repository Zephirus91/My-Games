package com.kodilla.tictactoe;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class GameController {
    private Image letterX = new Image("file:src/main/resources/TicTacToe/x.png");
    private Image letterO = new Image("file:src/main/resources/TicTacToe/o.png");
    private GameLogic gameLogic;
    private GridPane grid;
    private Stage stage;

    public GameController(GameLogic gameLogic, GridPane grid, Stage stage) {

        this.gameLogic = gameLogic;
        this.grid = grid;
        this.stage = stage;
    }

    public void click(int x, int y) {
        gameLogic.click(x,y);
        if (!gameLogic.checkWinner().equals(" ")) {
            Label label = new Label("You won");

            Popup popup = new javafx.stage.Popup();

            label.setStyle(" -fx-background-color: gray;");
            label.setFont(Font.font ("Verdana", 40));
            label.setTextFill(Color.ORANGE);

            popup.getContent().add(label);

            label.setMinWidth(150);
            label.setMinHeight(90);
            popup.show(stage);
        }
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
