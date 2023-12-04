package com.example.snake;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class viewController implements Controller{
        private  Model model;
        private  View view;

        @FXML
        private Button continueuButton;

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
                try {
                        playerName.setText("Player: " + nameLabel.getText().substring(0,5));
                } catch (Exception e) {
                        ;
                }



                nameLabel.setVisible(false);
                continueuButton.setVisible(false);
                questionLabel.setVisible(false);
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
                model.setHighScore(0);
                model.setHasFinished(false);
        }

        @Override
        public void startup() {

        }

        @Override
        public void update(int length, int score) {

        }
}
