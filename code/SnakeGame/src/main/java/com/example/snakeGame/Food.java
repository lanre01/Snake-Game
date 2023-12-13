package com.example.snakeGame;

import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public class Food extends GameObject implements Timer
{
	private double frameHeight, frameWidth;
	private double time = 1.0;
	private boolean eaten = false;
	private int foodScore = 300;

	public Food(double frameHeight, double frameWidth)	{
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
		this.image = ImageUtil.images.get(String.valueOf(new Random().nextInt(16)));
		this.objectWidth = image.getWidth();
		this.objectHeight = image.getHeight();
		this.xPosition = (int) (Math.random() * ( this.frameWidth - this.objectWidth * 2 ));
		this.yPosition = (int) (Math.random() * ( this.frameHeight - this.objectHeight * 2 ));
	}

	public boolean eaten(Snake snake) 	{
		if(eaten)
			return true;

        return this.getRectangle().intersects(snake.getRectangle());
    }
	@Override
	public void draw(GraphicsContext g) { g.drawImage(image, xPosition, yPosition); }

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
