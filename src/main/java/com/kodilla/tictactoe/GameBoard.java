package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameBoard extends Application {

    private Image imageback = new Image("file:src/main/resources/TicTacToe/grass.jpg");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(960, 626, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);
        grid.getRowConstraints().add(new RowConstraints(210));
        grid.getRowConstraints().add(new RowConstraints(210));
        grid.getRowConstraints().add(new RowConstraints(210));
        grid.getColumnConstraints().add(new ColumnConstraints(315));
        grid.getColumnConstraints().add(new ColumnConstraints(315));
        grid.getColumnConstraints().add(new ColumnConstraints(1400));


        Scene scene = new Scene(grid, 960, 626, Color.BLACK);

        GameLogic gameLogic = new GameLogic();
        GameController gameController = new GameController(gameLogic, grid);

        grid.setOnMouseClicked(event -> {
            System.out.println(event.getX());
            System.out.println(event.getY());
            int x = (int) (event.getX()/320);
            int y = (int) (event.getY()/210);
            System.out.println(x);
            System.out.println(y);
            gameController.click(x,y);
            gameController.showOnBoard();
        });



        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

