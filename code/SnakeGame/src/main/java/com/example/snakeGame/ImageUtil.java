package com.example.snakeGame;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class ImageUtil {
	public static Map<String, Image> images = new HashMap<>();

	public ImageUtil() {
	}
//com/example/snakeGame/2294056ad1aa7e15ed1f2337507fa19e.jpg
	static {
		images.put("snake-head-right", GameUtil.getImage("com/example/snakeGame/snake-head-right.png"));
		images.put("snake-body", GameUtil.getImage("com/example/snakeGame/snake-body.png"));
		images.put("0", GameUtil.getImage("com/example/snakeGame/food-kiwi.png"));
		images.put("1", GameUtil.getImage("com/example/snakeGame/food-lemon.png"));
		images.put("2", GameUtil.getImage("com/example/snakeGame/food-litchi.png"));
		images.put("3", GameUtil.getImage("com/example/snakeGame/food-mango.png"));
		images.put("4", GameUtil.getImage("com/example/snakeGame/food-apple.png"));
		images.put("5", GameUtil.getImage("com/example/snakeGame/food-banana.png"));
		images.put("6", GameUtil.getImage("com/example/snakeGame/food-blueberry.png"));
		images.put("7", GameUtil.getImage("com/example/snakeGame/food-cherry.png"));
		images.put("8", GameUtil.getImage("com/example/snakeGame/food-durian.png"));
		images.put("9", GameUtil.getImage("com/example/snakeGame/food-grape.png"));
		images.put("10", GameUtil.getImage("com/example/snakeGame/food-grapefruit.png"));
		images.put("11", GameUtil.getImage("com/example/snakeGame/food-peach.png"));
		images.put("12", GameUtil.getImage("com/example/snakeGame/food-pear.png"));
		images.put("13", GameUtil.getImage("com/example/snakeGame/food-orange.png"));
		images.put("14", GameUtil.getImage("com/example/snakeGame/food-pineapple.png"));
		images.put("15", GameUtil.getImage("com/example/snakeGame/food-strawberry.png"));
		images.put("16", GameUtil.getImage("com/example/snakeGame/food-watermelon.png"));
		images.put("UI-background", GameUtil.getImage("com/example/snakeGame/UI-background.png"));
		images.put("game-scene-01", GameUtil.getImage("com/example/snakeGame/game-scene-01.jpg"));
	}
}