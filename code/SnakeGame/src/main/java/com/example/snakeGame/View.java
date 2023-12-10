package com.example.snakeGame;

public interface View {
    /**
     * Initialise the view
     * @param model The model which has the information about the board
     * @param controller The controller to inform when something happens - e.g. a space is selected
     * @param height The height of the frame for the snake game
     * @param width The width of the frame for the snake game
     */
    void initialise( Model model, Controller controller, int height, int width );

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
