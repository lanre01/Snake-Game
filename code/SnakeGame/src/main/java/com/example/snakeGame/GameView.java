package com.example.snakeGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameView extends Application implements View   {
    Model model;
    Controller controller;
    int frameHeight, frameWidth;
    //public Image background = ImageUtil.images.get("UI-background");
    //public Image fail = ImageUtil.images.get("game-scene-01");
    //private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.images.get("snake-head-right");
    //static  Snake snake = new Snake(20, 20, IMG_SNAKE_HEAD);
    //Food food = new Food();


    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Snake Yipee");
        stage.setScene(scene);
        this.readImage();
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
    public  void readImage() {
        URL u = GameUtil.class.getClassLoader().getResource("com/example/snakeGame/game-scene-01.jpg");
        BufferedImage i = null;

        try {
            i = ImageIO.read(u);
        } catch (Exception var4) {
            System.err.println("VILLA : FINN EKKI TILTEKNA MYNDIN !\n");
            var4.printStackTrace();
        }


    }

}
