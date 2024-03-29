package com.example.snakeGame;

/**
 * Responsible for creating the stage for the game.
 * It also ensures the stage is refreshed at specific time interval to update the game.
 */
public interface View {
    /**
     * Initialise the view
     * @param model The model which has the information about the board
     * @param controller The controller to inform when something happens - e.g. a space is selected
     */
    void initialise(Model model, Controller controller );

    /**
     * Refresh the display
     */
    void refreshView();

    /**
     * Display a feedback message when the game ends
     * provide option for the user to either continue or end the game
     */
    void feedbackToUser();

}
