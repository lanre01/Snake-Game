package com.example.snakeGame;

import javafx.scene.canvas.Canvas;
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
     * Stores the current score and compare with the game high score.
     * saves the score if the score is higher or discard if otherwise.
     * @param object stores all parameters (menu, canvas) that need to be updated during the game
     */
    public void startup(ViewController.ObjectToNotify object) ;

    /**
     * Update the model when the snake eat food.
     * Checks if the game has ended or paused before drawing the snake and food.
     * update the score of the game.
     * draw the snake and the food.
     */
    void update();

    /**
     * listen for key press
     * change the direction of the snake depending on the key pressed
     * @param event for the key pressed
     */
    void onKeyPressed (KeyEvent event);

}
