package com.example.snakeGame;

import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javafx.geometry.Rectangle2D;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {
    static Snake snake;

    @BeforeAll
    static void startUp() {
        snake = new Snake(20,20, ImageUtil.images.get("snake-head-right"));
    }

    /**
     * test 4.1
     */
    @Test
    void testIfSnakeEadBody() {
        assertFalse(snake.eatBody());
    }

    /**
     * test 4.2
     */
    @Test
    void testIfSnakeOutOfBounds() {
        assertFalse(snake.outOfBounds(1));
        snake.setFrameWidthHeight(300,300);
        assertFalse(snake.outOfBounds(2));
    }

    /**
     * test 4.4
     */
    @Test
    void testIfSnakeCorrectlySetLength() {
        snake.setLength(3);
        assertEquals(3, snake.getLength());
    }

    /**
     * test 4.5
     */
    @Test
    void testIfSnakeMoves() {
        int x = snake.xPosition;
        int y = snake.yPosition;
        snake.move(1);
        assertNotEquals(x, snake.xPosition);
        assertEquals(5, snake.xPosition - x);
    }

    @Test
    void testIfSnakeReturnsARectangle() {
        assertTrue(snake.getRectangle() instanceof Rectangle2D);
    }
}