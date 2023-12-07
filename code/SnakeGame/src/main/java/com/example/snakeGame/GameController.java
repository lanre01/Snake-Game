package com.example.snakeGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameController implements Controller {

        Model model;
        View view;
        private  final Image IMG_SNAKE_HEAD = ImageUtil.images.get("snake-head-right");
          Snake snake = new Snake(160, 160, IMG_SNAKE_HEAD);
        Food food;

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
                food = new Food(canvas.getHeight(), canvas.getWidth());
                this.draw();
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




        @Override
        public void initialise(View view, Model model) {
                this.model = model;
                this.view = view;
                model.setSnakeLength(1);
                model.setScore(0);
                model.setHighScore(0);

                //highScorer.setText("High Score: " + model.getHighScore());


        }

        @Override
        public void startup() {
                model.setHasFinished(false);
                //this.draw();
        }

        @Override
        public void update(int length, int score) {
                this.model.setScore(this.model.getScore() + score);
                this.model.setSnakeLength(this.model.getSnakeLength() + length);
        }

        @Override
        public void onKeyPressed(KeyEvent event) {

        }

        @Override
        public void startOrPauseGame() {

        }

        private  void draw() {
                //GraphicsContext g = canvas.getGraphicsContext2D();
                snake.draw(canvas.getGraphicsContext2D());
                this.food.draw(canvas.getGraphicsContext2D());
        }
        /**
         * the controller draws the snake
         * the controller draws the food
         */

}
