package com.example.snakeGame;

/**
 * This class controls if a game object should move.
 */
public interface Movable
{
	/**
	 * This is used to move a game object
	 * @param level is the level of the game. The game object may
	 *                   move depending on the level of the game.
	 */
	void move(int level);
}
