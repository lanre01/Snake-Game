package com.example.snakeGame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The paddle class creates a rectangle on the screen.
 * The paddle must not be touched by the snake otherwise game ends.
 */
public class Paddle extends GameObject{

    /**
     * This is the color of the paddle.
     */
    public static final Color INNER_COLOR = Color.DARKRED;

    /**
     * Paddle constructor
     * @param xPosition the x position of the paddle on the view.
     * @param yPosition the y position of the paddle on the view.
     */
    public Paddle(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.objectWidth = 50;
        this.objectHeight = 20;
    }

    /**
     * Check if the snake has collided with the paddle.
     * @param snake is the snake in the game.
     * @return true if the snake has collided and false if otherwise.
     */
    public boolean eaten(Snake snake) {

        return this.getRectangle().intersects(snake.getRectangle());
    }

    @Override
    public void draw(GraphicsContext graphics) {
        graphics.setFill(INNER_COLOR);
        graphics.fillRect(xPosition, yPosition, this.objectWidth, this.objectHeight);
    }

}
