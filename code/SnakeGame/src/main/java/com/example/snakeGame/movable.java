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
	 * @param level is the level of the game. The game object may
	 *                   move depending on the level of the game.
	 */
	void move(int level);
}
