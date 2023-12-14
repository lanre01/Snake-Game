package com.example.snakeGame;

public interface Model {
    /**
     * initialise the model
     * set the initial score to zero
     */
    void initialise();
    /**
     * sets the player name. Player can choose to play as anonymous
     * @param player The name of the player
     * @param  level is the level the player is player.
     */
    void setPlayerName(String player, int level);

    /**
     * @return the player name.
     */
     String getPlayerName(int level);

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
    void setHighScore(int score, int level);

    /**
     * @return the previously stored high score if there is otherwise returns 0.
     */
    int getHighScore(int level);

    /**
     * set the current player score
     * @param Score value of the current player
     */
    void setScore(int Score);

    /**
     * returns the already stored score
     * @return the current player score.
     */
    int getScore();

    /**
     * stores whether the game is paused or running.
     * @return true if the game is currently running and false if otherwise.
     */
    boolean start();

    /**
     * set the current state of the program to either start or paused.
     * @param start is true when the game is running and false when the game is paused.
     */
    void setStart(boolean start);

    /**
     * set the difficulty of the game
     * @param level is 1, 2 or 3.
     */
    void setLevel(int level);

    /**
     * @return returns the level set by setLevel.
     */
    int getLevel();


}
