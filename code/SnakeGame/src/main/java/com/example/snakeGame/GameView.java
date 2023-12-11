package com.example.snakeGame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import java.io.IOException;

public class GameView extends Application implements View   {
    Model model;
    static Controller controller;
    Scene scene;
    Timeline timeline;

    @Override
    public void initialise(Model model, Controller controller) {
        this.model = model;
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
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("game-view.fxml"));
        scene = new Scene(fxmlLoader.load());

        scene.addEventFilter(Event.ANY, event -> {
            if (event instanceof KeyEvent keyEvent) {
                controller.onKeyPressed(keyEvent);
            }});

        stage.setTitle("Snake Yipee");
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(30), e -> {
            controller.update();
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }





}