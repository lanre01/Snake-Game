package com.example.snakeGame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    static Food food;
    static  Snake snake;
    @BeforeAll
    static void startUp() {
        food = new Food(300, 300);
        snake = new Snake(20, 20, ImageUtil.images.get("snake-head-right"));
    }

    /**
     * test 7.2
     */
    @Test
    void testIfFoodReturnsCorrectValueWhenEaten () {
        assertFalse(food.eaten(snake));
    }

    /**
     * test 7.3
     */
    @Test
    void  testIfFoodScoreIsTrue() {
        food = new Food(300, 300);
        assertEquals(300, food.getFoodScore());
    }

    @Test
    void testIfFoodDecrementsTime() {
        food.decrementTime();
        assertEquals(300-3, food.getFoodScore());
    }



}