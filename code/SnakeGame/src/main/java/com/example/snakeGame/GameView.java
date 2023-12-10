package com.example.snakeGame;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class GameView extends Application implements View   {
    Model model;
    static Controller controller;
    int frameHeight, frameWidth;
    public Image background = ImageUtil.images.get("UI-background");
    public Image fail = ImageUtil.images.get("game-scene-01");
    Scene scene;
    Timeline timeline;

    @Override
    public void initialise(Model model, Controller controller, int height, int width) {
        this.model = model;
        GameView.controller = controller;
        this.frameHeight = height;
        this.frameWidth = width;
        launch();
    }

    @Override
    public void refreshView() {
        controller.update();
    }

    @Override
    public void feedbackToUser() {

    }

    @Override
    public void start(Stage stage) throws IOException {
        UIInit(stage);
    }


    private void UIInit(Stage stage) throws IOException {
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100), e -> {
            this.refreshView();
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);

        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("game-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Snake Yipee");
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
        timeline.play();
    }




}
