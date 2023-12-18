package com.example.snakeGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageUtilTest {

    /**
     * test6.1
     */
    @Test
    void testIfTheHarshMapIsInitialised() {
        assertNotNull(ImageUtil.images);
    }

    /**
     * test 6.2
     */
    @Test
    void testRequiredAllFilesAreStored() {
         assertNotNull(ImageUtil.images.get("1"));
         assertNotNull(ImageUtil.images.get("15"));
        assertNotNull(ImageUtil.images.get("UI-background"));
    }

}