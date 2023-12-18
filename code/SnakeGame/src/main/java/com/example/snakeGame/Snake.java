package com.example.snakeGame;

import java.awt.*;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.LinkedList;
import java.util.List;

public class Snake extends GameObject implements movable {
    public static List<Point> bodyPoints = new LinkedList<>();
    private final Image IMG_SNAKE_HEAD = ImageUtil.images.get("snake-head-right");
    private  Image newImgSnakeHead = ImageUtil.images.get("snake-head-right");
    private boolean up, down, left;
    private boolean right = true;
    private final int snakeSpeed = 5;
    private final int spacing;
    int length;
    private double canvasWidth;
    private double canvasHeight;
    private int snakeHeadWidth, snakeHeadHeight;

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
        this.objectHeight = image.getHeight();
        this.objectWidth = image.getWidth();
        spacing = (int) (objectWidth / snakeSpeed);
        this.snakeHeadHeight = (int) IMG_SNAKE_HEAD.getHeight();
        this.snakeHeadWidth = (int) IMG_SNAKE_HEAD.getWidth();
    }

    /**
     * set the maximum width and height of the frame the snake draws on.
     * @param canvasWidth the width of the canvas
     * @param canvasHeight the height of the canvas
     */
    public void setFrameWidthHeight ( double canvasWidth, double canvasHeight ) {
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;
    }
    /**
     * Checks if the snack has collided with its own body.
     * @return true if the snake has collided with itself, the game can end and false if otherwise.
     */
    public boolean eatBody()
    {
        boolean body = false;
        for (Point point : bodyPoints)
        {
            for (Point point2 : bodyPoints)
            {
                if (point.equals(point2) && point != point2)
                {
                   return true;
                }
            }
        }
        return body;
    }

    /**
     * Checks if the snake is out of bound
     * @return true if the snake is out of bounds, the game can end and false if otherwise.
     */
    public boolean outOfBounds(int difficulty)
    {
        if(difficulty == 1)
            return  false;

        boolean bounds = false;
        boolean xOut = (this.xPosition <= 0 || this.xPosition >= (this.canvasWidth - objectWidth));
        boolean yOut = (this.yPosition <= 0 || this.yPosition >= (this.canvasHeight - objectHeight));
        if (xOut || yOut)
            return true;

        return  bounds;
    }

    /**
     * draws the whole snake on the view
     * Checks if the game has ended otherwise draws the snake
     * @param graphics on the view.
     */
    @Override
    public void draw( GraphicsContext graphics ) {
        bodyPoints.add( new Point( xPosition, yPosition ) );

        if (bodyPoints.size() >= (this.length + 1) * spacing) {
            bodyPoints.remove(0);
        }

        graphics.drawImage(newImgSnakeHead, xPosition, yPosition);
        drawBody(graphics);
    }

    /**
     * draw the body of the snake
     * @param g is the graphics to be drawn.
     */
    public void drawBody(GraphicsContext g)
    {
        int length = bodyPoints.size() - 1 - spacing;

        for (int i = length; i >= spacing; i -= spacing)
        {
            Point point = bodyPoints.get(i);
            g.drawImage(this.image, point.x, point.y);
        }
    }


    /**
     * controls the direction the snake is facing
     * @param e can only be the arrow keys left, right, up, down.
     */
    public void keyPressed( KeyEvent e )
    {
        switch (e.getCode())
        {
            case UP:
                if (!down)
                {
                    up = true;
                    left = false;
                    right = false;

                    newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
                    bodyPoints.removeLast();
                    this.move(0);
                }
                break;

            case DOWN:
                if (!up)
                {
                    down = true;
                    left = false;
                    right = false;

                    newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                    bodyPoints.removeLast();
                    this.move(0);
                }
                break;

            case LEFT:
                if (!right)
                {
                    up = false;
                    down = false;
                    left = true;

                    newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);
                    bodyPoints.removeLast();
                    this.move(0);
                }
                break;

            case RIGHT:
                if (!left)
                {
                    up = false;
                    down = false;
                    right = true;

                    newImgSnakeHead = IMG_SNAKE_HEAD;
                    bodyPoints.removeLast();
                    this.move(0);
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

    public void resetSnake() {
        bodyPoints.clear();
    }


    /**
     * Controls the movement of the snake on the view.
     * Add or subtract from the xPosition or yPosition based on the direction of the snake.
     */
    @Override
    public void move(int level) {
        if(level == 1){
            this.easyMove();
            return;
        }

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

    private void easyMove() {

        if (up) {
            this.yPosition -= snakeSpeed;
            if((this.yPosition - objectHeight/5) <= 0) {
                this.yPosition = (int) canvasHeight;
                this.yPosition -= snakeSpeed;
            }


        } else if (down) {
            this.yPosition += snakeSpeed;
            if((this.yPosition + objectHeight) >= canvasHeight) {
                this.yPosition = 0;
                this.yPosition += snakeSpeed;
            }



        } else if (left) {
            this.xPosition -= snakeSpeed;
            if(this.xPosition- objectWidth/5 <= 0) {
                this.xPosition = (int) canvasWidth;
                this.xPosition -= snakeSpeed;
            }


        } else if (right) {
            this.xPosition += snakeSpeed;
            if((this.xPosition + objectWidth) >= canvasWidth){
                this.xPosition = 0;
                this.xPosition += snakeSpeed;
                }




        }
    }
}
