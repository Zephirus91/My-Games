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
    private Image letterX = new Image("file:src/main/resources/TicTacToe/letter x.png");
    private Image letterO = new Image("file:src/main/resources/TicTacToe/letter o.png");
    private FlowPane symbols = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);
        grid.getRowConstraints().add(new RowConstraints(0));
        grid.getRowConstraints().add(new RowConstraints(265));
        grid.getRowConstraints().add(new RowConstraints(320));
        grid.getColumnConstraints().add(new ColumnConstraints(0));
        grid.getColumnConstraints().add(new ColumnConstraints(450));
        grid.getColumnConstraints().add(new ColumnConstraints(450));


        ImageView img1 = new ImageView(letterX);
        ImageView img2 = new ImageView(letterX);
        ImageView img3 = new ImageView(letterX);
        ImageView img4 = new ImageView(letterX);
        ImageView img5 = new ImageView(letterX);
        ImageView img6 = new ImageView(letterX);
        ImageView img7 = new ImageView(letterX);
        ImageView img8 = new ImageView(letterX);
        ImageView img9 = new ImageView(letterX);

        ImageView img10 = new ImageView(letterO);
        ImageView img11 = new ImageView(letterO);
        ImageView img12 = new ImageView(letterO);
        ImageView img13 = new ImageView(letterO);
        ImageView img14 = new ImageView(letterO);
        ImageView img15 = new ImageView(letterO);
        ImageView img16 = new ImageView(letterO);
        ImageView img17 = new ImageView(letterO);
        ImageView img18 = new ImageView(letterO);

        grid.add(img1, 1, 1, 3, 1);
        grid.add(img2, 2, 1, 3, 1);
        grid.add(img3, 3, 1, 3, 1);
        grid.add(img4, 1, 2, 3, 1);
        grid.add(img5, 2, 2, 3, 1);
        grid.add(img6, 3, 2, 3, 1);
        grid.add(img7, 1, 3, 3, 1);
        grid.add(img8, 2, 3, 3, 1);
        grid.add(img9, 3, 3, 3, 1);

        Scene scene = new Scene(grid, 1380, 900, Color.BLACK);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
