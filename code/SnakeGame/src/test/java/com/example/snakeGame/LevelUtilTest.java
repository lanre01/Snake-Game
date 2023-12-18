package com.example.snakeGame;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelUtilTest {
    @Test
    void testIfTheHashMapIsInitialised() {
        assertNotNull(LevelUtil.images);
    }

    @Test
    void  testAllRequiredScenesAreStore() {
        assertTrue(LevelUtil.images.get("1") instanceof Image);
        assertTrue(LevelUtil.images.get("2") instanceof Image);
        assertTrue(LevelUtil.images.get("3") instanceof Image);
    }

}