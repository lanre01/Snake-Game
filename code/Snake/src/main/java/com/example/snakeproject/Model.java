package com.example.snakeproject;

public interface Model {
    /**
     * sets the player name. Player can choose to play as anonymous
     * @param player The name of the player
     */
    void setPlayerName( String player );

    /**
     * @return the player name.
     */
    String getPlayerName();

    /**
     * set the length of the snake
     * @param length The new length of the snake.
     */
    void setSnakeLength( int length );

    /**
     * @return the length of the snake.
     */
    int getSnakeLength();

    /**
     * @return true if the game has finished or false if the game has not finished.
     */
    boolean hasFinished();

    /**
     * Store whether the game has finished or not
     * @param finished set true if the game has finished and false if the game has not finished
     */
    void setHasFinished( boolean finished );

    /**
     * Store whether food exist on the frame
     * @param food set true if food is on the view and false if the food has been eaten.
     */
    void setFood( boolean food );

    /**
     * Determine whether there is food on the frame
     * @return true if there is food on the view and false if otherwise
     */
    boolean getFood();

    /**
     * Stores the high score of the player.
     * @param score of the player if the score is greater than the stored high score.
     */
    void setHighScore( int score );

    /**
     * @return the previously stored high score if there is otherwise returns 0.
     */
    int getHighScore();

    /**
     * set the current player score
     * @param Score value of the current player
     */
    void setScore(int Score);

    /**
     * returns the already stored score
     * @return the current player score
     */
    int getScore();


}
