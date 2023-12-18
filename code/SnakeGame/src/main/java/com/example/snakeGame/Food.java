package com.example.snakeGame;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

/**
 * The food class get an image from the ImageUtil class at random.
 * It draws the food on the view.
 * It can detect when a snake collide with itself.
 */
public class Food extends GameObject implements Timer
{
	private double frameHeight, frameWidth;
	private double time = 1.0;
	private boolean eaten = false;
	private int foodScore = 300;

	/**
	 * Food Constructor
	 * @param frameHeight is the height of the view the food can be drawn on. It ensures the food is not drawn outside the view.
	 * @param frameWidth is the width of the frame the food can be drawn on. It ensures the food is not drawn outside the view.
	 */
	public Food(double frameHeight, double frameWidth)	{
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
		this.image = ImageUtil.images.get(String.valueOf(new Random().nextInt(16)));
		this.objectWidth = image.getWidth();
		this.objectHeight = image.getHeight();
		this.xPosition = (int) (Math.random() * ( this.frameWidth - this.objectWidth * 2 ));
		this.yPosition = (int) (Math.random() * ( this.frameHeight - this.objectHeight * 2 ));
	}

	/**
	 * Detects when the snake collide with the food.
	 * @param snake is the snake in the game
	 * @return true if the game has collided with the food or the food time is up on the view.
	 * It returns false if the food timer is not up and the snake has not collided with the food.
	 */
	public boolean eaten(Snake snake) 	{
		if(eaten)
			return true;

        return this.getRectangle().intersects(snake.getRectangle());
    }
	@Override
	public void draw(GraphicsContext g) { g.drawImage(image, xPosition, yPosition); }

	/**
	 *
	 * @return the food score.
	 * The food score is not always constant.
	 * At higher levels, the food score decrement after every 30ms by a fixed amount.
	 */
	public int getFoodScore() {
        return Math.max(foodScore, 0);
    }

	@Override
	public void decrementTime() {
		if(time <= 0) {
			eaten = true;
		}
		else {
			time -= 0.01;
			foodScore -= 3;
		}
	}
}
