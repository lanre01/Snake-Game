package com.example.snakeGame;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameUtilTest {

    /**
     * test 5.2
     */
    @Test
    void testToCheckIfImageIsReturned() {
        Image image = GameUtil.getImage("Foods/food-apple.png");
        assertNotNull(image);
    }



}