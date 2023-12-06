package com.example.snakeGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class Snake extends GameObject implements movable {
    int xPosition, yPosition, objectWidth, objectHeight;
    public static List<Point> bodyPoints = new LinkedList<>();
    private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.images.get("snake-head-right");
    private static BufferedImage newImgSnakeHead;
    boolean up, down, left, right = true;
    private final int snakeSpeed = 5;
    private int spacing;
    int length;
    /**
     * Constructor for the Snake class
     * @param xPosition of the snake on the view
     * @param yPosition of the snake on the view
     * @param image the snake body image
     */
    public  Snake( int xPosition, int yPosition, Image image ) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.image = image;
        this.objectHeight = image.getHeight(null);
        this.objectWidth = image.getWidth(null);
        spacing = objectWidth / snakeSpeed;
        length = 1;
    }

    /**
     * Checks if the snack has collided with its own body.
     * @return true if the snake has collided with itself, the game can end and false if otherwise.
     */
    public boolean eatBody()
    {
        boolean body = true;
        for (Point point : bodyPoints)
        {
            for (Point point2 : bodyPoints)
            {
                if (point.equals(point2) && point != point2)
                {
                   return false;
                }
            }
        }
        return body;
    }

    /**
     * Checks if the snake is out of bound
     * @return true if the snake is out of bounds, the game can end and false if otherwise.
     */
    private boolean outOfBounds()
    {   boolean bounds = false;
        boolean xOut = (this.xPosition <= 0 || this.xPosition >= (870 - objectWidth));
        boolean yOut = (this.yPosition <= 40 || this.yPosition >= (560 - objectHeight));
        if (xOut || yOut)
        {
            return true;
        }
        return  bounds;
    }

    /**
     * draws the whole snake on the view
     * Checks if the game has ended otherwise draws the snake
     * @param graphics on the view.
     */
    @Override
    public void draw(Graphics graphics) {
        if(!outOfBounds() && !eatBody()) {
            bodyPoints.add( new Point( xPosition, yPosition ) );

            if (bodyPoints.size() == (this.length + 1) * spacing) {
                bodyPoints.remove(0);
            }
            graphics.drawImage(newImgSnakeHead, xPosition, yPosition, null);
            drawBody(graphics);

            move();
        }
    }

    /**
     * draw the body of the snake
     * @param g is the graphics to be drawn.
     */
    public void drawBody(Graphics g)
    {
        int length = bodyPoints.size() - 1 - spacing;

        for (int i = length; i >= spacing; i -= spacing)
        {
            Point point = bodyPoints.get(i);
            g.drawImage(this.image, point.x, point.y, null);
        }
    }

    /**
     * controls the direction the snake is facing
     * @param e can only be the arrow keys left, right, up, down.
     */
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (!down)
                {
                    up = true;
                    left = false;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
                }
                break;

            case KeyEvent.VK_DOWN:
                if (!up)
                {
                    down = true;
                    left = false;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                }
                break;

            case KeyEvent.VK_LEFT:
                if (!right)
                {
                    up = false;
                    down = false;
                    left = true;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);

                }
                break;

            case KeyEvent.VK_RIGHT:
                if (!left)
                {
                    up = false;
                    down = false;
                    right = true;

                    newImgSnakeHead = IMG_SNAKE_HEAD;
                }

            default:
                break;
        }
    }

    /**
     * set the length of the snake to a new length when the snake eat food.
     * @param length is greater than the previous length
     */
    public void setLength( int length ){this.length = length;}

    /**
     * @return the length of the snake
     */
    public int getLength() {return this.length;}

    /**
     * Controls the movement of the snake on the view.
     * Add or subtract from the xPosition or yPosition based on the direction of the snake.
     */
    @Override
    public void move() {
        if (up)
        {
            yPosition -= snakeSpeed;
        } else if (down)
        {
            yPosition += snakeSpeed;
        } else if (left)
        {
            xPosition -= snakeSpeed;
        } else if (right)
        {
            xPosition += snakeSpeed;
        }
    }
}
