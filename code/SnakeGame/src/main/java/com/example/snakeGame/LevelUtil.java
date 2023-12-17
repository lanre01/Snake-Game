package com.example.snakeGame;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class LevelUtil {
    public static Map<String, Image> images = new HashMap<>();

    public LevelUtil() {
    }

    static {
        images.put("1", GameUtil.getImage("Scenes/UI-background.png"));
        images.put("2", GameUtil.getImage("Scenes/UI-background2.png"));
        images.put("3", GameUtil.getImage("Scenes/UI-background3.png"));
    }
}
