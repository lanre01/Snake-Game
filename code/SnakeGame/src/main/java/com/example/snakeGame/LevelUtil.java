package com.example.snakeGame;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * This class stores all the scenes needed in the game.
 */
public class LevelUtil {
    /**
     * Hashmap that stores the scenes used in the game
     */
    public static Map<String, Image> images = new HashMap<>();

    /**
     * No use
     */
    public LevelUtil() {}

    static {
        images.put("0", GameUtil.getImage("Scenes/home-scene.jpg"));
        images.put("1", GameUtil.getImage("Scenes/UI-background.png"));
        images.put("2", GameUtil.getImage("Scenes/UI-background2.png"));
        images.put("3", GameUtil.getImage("Scenes/UI-background3.png"));
    }
}
