package com.example.snakeGame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ViewController {
    static Controller controller;
    static Model model;


    @FXML
    private Button ExitButton;

    @FXML
    private Button RestartButton;
    @FXML
    private ImageView endScene;

    @FXML
    private Menu scoreMenu;
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
    void restartGame(MouseEvent event) {
        controller.startup(new ObjectToNotify(canvas, scoreMenu, ExitButton, RestartButton, endScene));
    }
    @FXML
    void exitGame(MouseEvent event) {
        ExitButton.setOnAction(e -> Platform.exit());
    }
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
    void keyPressed(KeyEvent event) {

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

        controller.startup(new ObjectToNotify(canvas, scoreMenu, ExitButton, RestartButton, endScene));
    }

    @FXML
    void pauseOrStartGame(MouseEvent event) {
        model.setStart(!model.start());
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

    /**
     * Store parameters that need to be updated when the snake game is running
     * This class can be used to store value on the FXML view that needs to be updated
     */
    public class  ObjectToNotify {
        public Menu scoreMenu;
        public Canvas canvas;
        public ImageView imageView;
        public Button ExitButton;
        public Button RestartButton;

        /**
         * Constructor for the class
         * @param canvas for the controller to draw.
         * @param scoreMenu displays the game score.
         */
        private ObjectToNotify(Canvas canvas, Menu scoreMenu, Button ExitButton, Button RestartButton, ImageView imgView) {
            this.canvas = canvas;
            this.scoreMenu = scoreMenu;
            this.imageView = imgView;
            this.ExitButton = ExitButton;
            this.RestartButton = RestartButton;
        }

    }


}
