package example;

import java.awt.*;

public abstract class GameObject {
    int xPosition, yPosition, objectWidth, objectHeight;
    Image image;
    /**
     * draw the game object
     * @param graphics on the view.
     */
    public abstract void draw(Graphics graphics);

    /**
     * used to get the position and size of the game object.
     * @return the rectangle covered by the game object.
     */
    public Rectangle getRectangle()
    {
        return new Rectangle(xPosition, yPosition, objectWidth, objectHeight);
    }
}
