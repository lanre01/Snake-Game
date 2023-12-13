package com.example.snakeGame;

/**
 * 
 * @Project Snakee
 * @Description Fyrsta viðmótið
 * @Author Sigurður Sigurðardóttir
 * @version Ekki viss
 */ 

public interface movable
{
	/**
	 * This is used to move a game object
	 * @param difficulty is the difficulty level of the game. The game object may
	 *                   move depending on the difficulty of the game.
	 */
	void move(int difficulty);
}
