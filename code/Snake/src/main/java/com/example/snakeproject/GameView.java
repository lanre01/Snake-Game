package com.example.snakeproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameView extends Application implements View   {
    Model model;
    Controller controller;
    int frameHeight, frameWidth;
    public Image background = ImageUtil.images.get("UI-background");
    public Image fail = ImageUtil.images.get("game-scene-01");
    private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.images.get("snake-head-right");
    static  Snake snake = new Snake(20, 20, IMG_SNAKE_HEAD);
    Food food = new Food();


    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Snake Yipee");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void initialise(Model model, Controller controller, int height, int width) {
        this.model = model;
        this.controller = controller;
        this.frameHeight = height;
        this.frameWidth = width;


    }

    @Override
    public void refreshView() {

    }

    @Override
    public void feedbackToUser() {

    }

}
