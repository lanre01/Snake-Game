package com.example.snakeGame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * This controls the FXML files used in the game application.
 */
public class ViewController {
    static Controller controller;
    static Model model;


    @FXML
    private MenuItem musicButton;

    @FXML
    private Pane CongratsPane;

    @FXML
    private Button ExitButton;

    @FXML
    private Button ExitButton3;

    @FXML
    private Menu levelText;

    @FXML
    private MenuItem Level1;

    @FXML
    private MenuItem Level2;

    @FXML
    private MenuItem Level3;

    @FXML
    private Pane ProgressPane;

    @FXML
    private Button RestartButton;

    @FXML
    private Button RestartButton3;

    @FXML
    private Canvas canvas;

    @FXML
    private Button continueButton;

    @FXML
    private Pane endPane;

    @FXML
    private ImageView endScene;

    @FXML
    private MenuItem Menurestart;

    @FXML
    private MenuItem ExitButton4;

    @FXML
    private Button ExitButton2;

    @FXML
    private Menu highScore;

    @FXML
    private MenuItem highScorer;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private MenuButton menuButtonForDifficulty;

    @FXML
    private TextField nameLabel;

    @FXML
    private Button nextLevel;

    @FXML
    private Button pauseButton;

    @FXML
    private Menu playerName;

    @FXML
    private Label questionLabel;

    @FXML
    private ImageView rootImageView;

    @FXML
    private Menu scoreMenu;

    @FXML
    private Pane startPane;

    /**
     * No use
     */
    public  ViewController() {}

    /**
     * Used to restart the game.
     * @param event from the restart button.
     */
    @FXML
    void restartGame(MouseEvent event) {
        endPane.setVisible(false);
        startPane.setVisible(true);
        CongratsPane.setVisible(false);
        if(nameLabel.getText().length() <= 5) {
            if(!nameLabel.getText().isEmpty()) {
                playerName.setText("Player: " + nameLabel.getText());

            }
        }
        else {
            playerName.setText("Player: " + nameLabel.getText().substring(0,5));
        }
        model.setPlayerName(nameLabel.getText());
    }

    /**
     * Used to exit the game and also pause the game.
     * @param event is from when exit buttons are clicked
     */
    @FXML
    void exitGame(MouseEvent event) {
       Platform.exit();
       MusicPlayer.stopPlaying();
    }

    /**
     * Used to change level from the home screen.
     * @param event when on the level menu is pressed
     */
    @FXML
    void changeLevel(ActionEvent event) {

        if( event.getSource() == Level1 ){
            menuButtonForDifficulty.setText(Level1.getText());
            model.setLevel(1);
        }
        else if( event.getSource() == Level2 ) {
            menuButtonForDifficulty.setText(Level2.getText());
            model.setLevel(2);
        }
        else if( event.getSource() == Level3 ) {
            menuButtonForDifficulty.setText(Level3.getText());
            model.setLevel(3);
        }
    }


    /**
     * Starts the game
     * @param event when start is clicked
     */
    @FXML
    void onStart(MouseEvent event) {
        if(nameLabel.getText().length() <= 5) {
            if(!nameLabel.getText().isEmpty()) {
                playerName.setText("Player: " + nameLabel.getText());

            }
        }
        else {
            playerName.setText("Player: " + nameLabel.getText().substring(0,5));
        }
        model.setPlayerName(nameLabel.getText());
        ProgressPane.setVisible(false);
        startPane.setVisible(false);
        pauseButton.setDisable(false);
        controller.startup(new ObjectToNotify());
    }


    /**
     * Controls when the game is start or paused.
     * @param event is the mouse event when the pause button is clicked.
     */
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

    /**
     * Initialise the ViewController
     * @param controller is the controller for the ViewController
     * @param model is th model for the ViewController.
     */
    public void initialise(Controller controller, Model model) {
        ViewController.controller = controller;
        ViewController.model = model;
    }

    /**
     * controls the view when the Menu item in settings is clicked
     * @param event when the menu items are clicked.
     */
    @FXML
    void menuExitOrRestart(ActionEvent event) {
        if(event.getSource() == ExitButton4) {
            MusicPlayer.stopPlaying();
            Platform.exit();
        }
        else if(event.getSource() == Menurestart) {
            endPane.setVisible(false);
            startPane.setVisible(true);
            CongratsPane.setVisible(false);
        }

    }

    /**
     * Used to pause or play music
     * @param event is when the menu item is clicked
     */
    @FXML
    void playOrPauseMusic(ActionEvent event) {
        if(model.isMusic()){
            model.setMusic(false);
            musicButton.setText("Turn on music");
            MusicPlayer.stopPlaying();
        }
        else if(!model.isMusic()) {
            model.setMusic(true);
            musicButton.setText("Turn of music");

            MusicPlayer.getMusicPlay("src/main/resources/com/example/snakeGame/Music/frogger.mp3");
        }
    }


    /**
     * Store parameters that need to be updated when the snake game is running
     * This class can be used to store any parameter on the FXML view that needs to be updated
     */
    public class ObjectToNotify {
        public Menu scoreMenu;
        public Canvas canvas;
        public MenuItem highScorer;
        public Menu highScore;
        public Menu playerName;
        public Pane endPane, congratPane;
        public Pane ProgressPane;
        public MenuItem Level1, Level2, Level3;
        public  ImageView rootImage;
        public Menu levelText;

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
            this.ProgressPane = ViewController.this.ProgressPane;
            this.Level1 = ViewController.this.Level1;
            this.Level2 = ViewController.this.Level2;
            this.Level3 = ViewController.this.Level3;
            this.levelText = ViewController.this.levelText;
            this.congratPane = ViewController.this.CongratsPane;
            this.rootImage = ViewController.this.rootImageView;
        }

    }


}
