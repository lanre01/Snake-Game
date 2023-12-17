package com.example.snakeGame;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class LevelUtil {
    public static Map<String, Image> images = new HashMap<>();

    public LevelUtil() {
    }

    static {
        images.put("1", GameUtil.getImage("Foods/food-lemon.png"));
        images.put("2", GameUtil.getImage("Foods/food-litchi.png"));
        images.put("3", GameUtil.getImage("Foods/food-mango.png"));


    }
}
