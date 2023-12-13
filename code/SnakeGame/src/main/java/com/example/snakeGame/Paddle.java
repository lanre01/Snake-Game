package com.example.snakeGame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * paddle class creates a rectangle on the screen
 * the paddle must not be touched by the snake otherwise game ends.
 */

public class Paddle extends GameObject implements movable {

    public static final Color INNER_COLOR = Color.DARKRED;

    public static final int DEF_MOVE_AMOUNT = 5;

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

    @Override
    public void move(int level) {
        if( level != 3)
            return;

    }

    @Override
    public void draw(GraphicsContext graphics) {
        graphics.setFill(INNER_COLOR);
        graphics.fillRect(xPosition, yPosition, this.objectWidth, this.objectHeight);
    }

}
