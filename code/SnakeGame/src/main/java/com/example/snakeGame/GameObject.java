package com.example.snakeGame;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * This class is inherited by any game object that is needed in the game.
 * It provides an abstract method draw() which the game object will define by itself.
 */
public abstract class GameObject {
    int xPosition, yPosition;
    double objectWidth, objectHeight;
    Image image;

    /**
     * No use
     */
    public GameObject() {}

    /**
     * draw the game object
     * @param graphics on the view.
     */
    public abstract void draw(GraphicsContext graphics);

    /**
     * used to get the position and size of the game object.
     * @return the rectangle covered by the game object.
     */
    public Rectangle2D getRectangle()
    {
        return new Rectangle2D(xPosition, yPosition, objectWidth, objectHeight);
    }
}
