package com.example.snakeGame;

/**
 * Used to decrement the time for the game object.
 * The game object property may change when the time is fully decremented.
 */
public interface Timer {
    /**
     * The function decreases the time on every refresh of the screen.
     */
    void decrementTime();
}
