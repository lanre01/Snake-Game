package com.example.snakeGame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * paddle class creates a rectangle on the screen
 * the paddle must not be touched by the snake otherwise game ends.
 * the paddles may be able to move
 * needs a points x, y , graphics context, needs to be able to check if the snake has eaten it.
 */

public class Paddle extends GameObject implements movable {


    public static final Color BORDER_COLOR = Color.GREEN.darker().darker();
    public static final Color INNER_COLOR = Color.GREEN;

    public static final int DEF_MOVE_AMOUNT = 5;


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
        graphics.setFill(Color.DARKRED);
        graphics.fillRect(xPosition, yPosition, this.objectWidth, this.objectHeight);
    }

}
