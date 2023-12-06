package com.example.snakeproject;

import javafx.scene.input.KeyEvent;

public interface Controller {
    /**
     * initialise the controller
     * @param view The view used in the game
     * @param model The model where all data are stored
     */
    void initialise(View view, Model model);

    /**
     * Startup the game
     * Stores the current score and compare with the game high score
     * saves the score if the score is higher or discard if otherwise
     */
    void startup();

    /**
     * Update the model when the snake eats a food
     * @param length The value to be added to the snake length
     * @param score The score to be added to the game score
     */
    void update( int length, int score );

    /**
     * listen for key press
     * change the direction of the snake depending on the key pressed
     * @param event for the key pressed
     */
    void onKeyPressed (KeyEvent event);

    /**
     * start or pause the game
     */
    void startOrPauseGame();
}
