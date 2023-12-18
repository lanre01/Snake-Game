package com.example.snakeGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevelUtilTest {
    /**
     * test 7.1
     */
    @Test
    void testIfTheHashMapIsInitialised() {
        assertNotNull(LevelUtil.images);
    }

    /**
     * test 7.2
     */
    @Test
    void  testAllRequiredScenesAreStore() {
        assertNotNull(LevelUtil.images.get("1"));
        assertNotNull(LevelUtil.images.get("2"));
        assertNotNull(LevelUtil.images.get("3"));
    }
}