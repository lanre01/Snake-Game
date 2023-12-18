package com.example.snakeGame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import java.io.IOException;

public class GameView extends Application implements View   {
    static Model model;
    static Controller controller;
    Scene scene;
    Timeline timeline;
    Image icon = GameUtil.getImage("Snake/snake-logo.png");

    @Override
    public void initialise(Model model, Controller controller) {
        GameView.model = model;
        GameView.controller = controller;
        launch();
    }

    @Override
    public void refreshView() {

    }

    @Override
    public void feedbackToUser() {

    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("FXML/game-view.fxml"));
        scene = new Scene(fxmlLoader.load());

        scene.addEventFilter(Event.ANY, event -> {
            if (event instanceof KeyEvent keyEvent) {
                if(model.start())
                    controller.onKeyPressed(keyEvent);
            }});

        stage.setTitle("Snake Yipee");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(icon);
        stage.show();
        stage.setOnCloseRequest(event -> {
            MusicPlayer.stopPlaying();
        });
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(30), e -> {
            controller.update();
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }





}
