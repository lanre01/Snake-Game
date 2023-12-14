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
import javafx.scene.layout.Pane;

public class ViewController {
    static Controller controller;
    static Model model;


    @FXML
    private Button ExitButton;

    @FXML
    private Button RestartButton;

    @FXML
    private Canvas canvas;

    @FXML
    private Button continueButton;


    @FXML
    private MenuItem easyMenuButton;

    @FXML
    private Pane endPane;

    @FXML
    private ImageView endScene;

    @FXML
    private MenuItem exit;

    @FXML
    private MenuItem exit2;

    @FXML
    private MenuItem hardMenuButton;

    @FXML
    private Menu highScore;

    @FXML
    private MenuItem highScorer;

    @FXML
    private AnchorPane mainAnchor;


    @FXML
    private MenuItem mediumMenuButton;

    @FXML
    private MenuButton menuButtonForDifficulty;

    @FXML
    private TextField nameLabel;

    @FXML
    private Button pauseButton;

    @FXML
    private Menu playerName;

    @FXML
    private Label questionLabel;

    @FXML
    private Menu scoreMenu;

    @FXML
    private Pane startPane;
    @FXML
    private ImageView rootImageView;

    @FXML
    void restartGame(MouseEvent event) {
        endPane.setVisible(false);
        startPane.setVisible(true);
        nameLabel.setDisable(true);
    }
    @FXML
    void exitGame(MouseEvent event) {
        ExitButton.setOnAction(e -> Platform.exit());
    }
    @FXML
    void changeDifficulty(ActionEvent event) {
        if( event.getSource() == easyMenuButton ){
            menuButtonForDifficulty.setText(easyMenuButton.getText());
            model.setLevel(1);
        }
        else if( event.getSource() == mediumMenuButton ) {
            menuButtonForDifficulty.setText(mediumMenuButton.getText());
            model.setLevel(2);
        }
        else if( event.getSource() == hardMenuButton ) {
            menuButtonForDifficulty.setText(hardMenuButton.getText());
            model.setLevel(3);
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

        startPane.setVisible(false);
        pauseButton.setDisable(false);
        controller.startup(new ObjectToNotify());
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
        public MenuItem highScorer;
        public Menu highScore;
        public Menu playerName;
        public  Pane endPane;

        /**
         * Constructor for the class
         */
        private ObjectToNotify() {
            this.canvas = ViewController.this.canvas;
            this.scoreMenu = ViewController.this.scoreMenu;
            this.highScorer = ViewController.this.highScorer;
            this.highScore = ViewController.this.highScore;
            this.playerName = ViewController.this.playerName;
            this.endPane = ViewController.this.endPane;
        }

    }


}
