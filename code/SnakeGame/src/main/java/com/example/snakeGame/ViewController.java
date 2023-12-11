package com.example.snakeGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ViewController {
    static Controller controller;
    static Model model;

    @FXML
    private static Menu scoreMenu;
    @FXML
    private Canvas canvas;

    @FXML
    private Button continueButton;

    @FXML
    private MenuItem easy;

    @FXML
    private MenuItem exit;

    @FXML
    private MenuItem exit2;

    @FXML
    private MenuItem hard;

    @FXML
    private MenuItem highScorer;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private MenuItem medium;

    @FXML
    private TextField nameLabel;

    @FXML
    private Button pauseButton;

    @FXML
    private Menu playerName;

    @FXML
    private Label questionLabel;
    @FXML
    void changeDifficulty(ActionEvent event) {
        if( event.getSource() == easy ){

        }
        else if( event.getSource() == medium ) {

        }
        else if( event.getSource() == hard ) {

        }
    }

    @FXML
    void exitGame(ActionEvent event) {

    }

    @FXML
    void keyPressed(KeyEvent event) {
        controller.onKeyPressed(event);
        if(event.getCode() == KeyCode.UP)
            System.out.println("lawal");
    }


    @FXML
    void onContinue(MouseEvent event) {
        if(nameLabel.getText().length() <= 5) {
            if(!nameLabel.getText().isEmpty())
                playerName.setText("Player: " + nameLabel.getText());
        }
        else {
            playerName.setText("Player: " + nameLabel.getText().substring(0,5));
        }

        nameLabel.setVisible(false);
        continueButton.setVisible(false);
        questionLabel.setVisible(false);

        controller.startup(canvas);
    }

    @FXML
    void pauseOrStartGame(ActionEvent event) {
        String buffer = pauseButton.getText();
        if(buffer.compareToIgnoreCase("pause") == 0){
            pauseButton.setText("Play");
        }
        else {
            pauseButton.setText("Pause");
        }
    }

    public void initialise(Controller controller, Model model) {
        ViewController.controller = controller;
        ViewController.model = model;
    }

    public void setScore() {
        scoreMenu.setText("Score: " + model.getScore());
    }

}
