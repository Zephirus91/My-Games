package com.kodilla.tictactoe;

import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;

public class MouseClicker extends StackPane {

    public MouseClicker() {
        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                getX();
            } else if (event.getButton() == MouseButton.SECONDARY) {
                getO();
            }
        });
    }

    private void getX() {

    }

    private void getO() {

    }
}
