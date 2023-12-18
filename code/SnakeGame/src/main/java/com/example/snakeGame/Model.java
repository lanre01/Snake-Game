package com.example.snakeGame;

/**
 * It stores all the data needed in the game.
 * It has getters and setters that the controllers can use to access the data.
 */
public interface Model {

    /**
     * initialise the model
     * set the initial score to zero
     */
    void initialise();
    /**
     * Sets the player name. Player can choose to play as anonymous.
     * @param player The name of the player
     */
    void setPlayerName(String player);

    /**
     * Gets the player name.
     * @return the player name set by the setPlayerName method.
     */
     String getPlayerName();

    /**
     * Set the length of the snake.
     * @param length The new length of the snake.
     */
    void setSnakeLength( int length );

    /**
     * Gets the snake length.
     * @return the length of the snake.
     */
    int getSnakeLength();

    /**
     * Checks if the game has finished.
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
    void setHighScore(int score);

    /**
     * Gets the high score of the game.
     * @return the previously stored high score if there is otherwise returns 0.
     */
    int getHighScore();

    /**
     * set the current player score
     * @param score value of the current player
     * @param level current level of the game.
     */
    void setScore(int score, int level);

    /**
     * Returns the already stored score.
     * @param level current level of the game.
     * @return the current player score.
     */
    int getScore(int level);

    /**
     * stores whether the game is paused or running.
     * @return true if the game is currently running and false if otherwise.
     */
    boolean start();

    /**
     * Set the current state of the program to either start or paused.
     * @param start is true when the game is running and false when the game is paused.
     */
    void setStart(boolean start);

    /**
     * Set the difficulty of the game.
     * @param level is 1, 2 or 3.
     */
    void setLevel(int level);

    /**
     * Gets the level set by the setLevel.
     * @return returns the level set by setLevel.
     */
    int getLevel();

    /**
     * Gets the maxScore a player can score in the current level
     * @param level is the current level of the game
     * @return the maximum score for the current level
     */
    int getMaxScore(int level);


    /**
     *
     * @param Level is the level of the game.
     * @return the minimum score for the level.
     */
    int getMinimumScore( int Level );

    /**
     * Gets the maximum level in the game.
     * @return the maximum level of the game.
     */
    int getMaxLevel();

}
