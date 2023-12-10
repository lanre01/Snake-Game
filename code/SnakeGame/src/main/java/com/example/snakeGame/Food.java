package com.example.snakeGame;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;

public class Food extends GameObject
{
	double frameHeight, frameWidth;

	public Food(double frameHeight, double frameWidth)	{
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
		this.image = ImageUtil.images.get(String.valueOf(new Random().nextInt(16)));
		this.objectWidth = (int) image.getWidth();
		this.objectHeight = (int) image.getHeight();
		this.xPosition = (int) (Math.random() * (this.frameWidth - this.objectWidth + 10));
		this.yPosition = (int) (Math.random() * (this.frameHeight - this.objectHeight - 40));
	}

	public boolean eaten(Snake snake) 	{

        return snake.getRectangle().intersects(this.getRectangle());
    }
	@Override
	public void draw(GraphicsContext g) { g.drawImage(image, xPosition, yPosition); }

}
