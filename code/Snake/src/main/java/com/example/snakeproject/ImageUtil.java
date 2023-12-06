package com.example.snakeproject;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class ImageUtil {
	public static Map<String, Image> images = new HashMap();

	public ImageUtil() {
	}
//com/example/snake/food-apple.png
	static {
		images.put("snake-head-right", GameUtil.getImage("com/example/snake/snake-head-right.png"));
		images.put("snake-body", GameUtil.getImage("com/example/snake/snake-body.png"));
		images.put("0", GameUtil.getImage("com/example/snake/food-kiwi.png"));
		images.put("1", GameUtil.getImage("com/example/snake/food-lemon.png"));
		images.put("2", GameUtil.getImage("com/example/snake/food-litchi.png"));
		images.put("3", GameUtil.getImage("com/example/snake/food-mango.png"));
		images.put("4", GameUtil.getImage("com/example/snake/food-apple.png"));
		images.put("5", GameUtil.getImage("com/example/snake/food-banana.png"));
		images.put("6", GameUtil.getImage("com/example/snake/food-blueberry.png"));
		images.put("7", GameUtil.getImage("com/example/snake/food-cherry.png"));
		images.put("8", GameUtil.getImage("com/example/snake/food-durian.png"));
		images.put("9", GameUtil.getImage("com/example/snake/food-grape.png"));
		images.put("10", GameUtil.getImage("com/example/snake/food-grapefruit.png"));
		images.put("11", GameUtil.getImage("com/example/snake/food-peach.png"));
		images.put("12", GameUtil.getImage("com/example/snake/food-pear.png"));
		images.put("13", GameUtil.getImage("com/example/snake/food-orange.png"));
		images.put("14", GameUtil.getImage("com/example/snake/food-pineapple.png"));
		images.put("15", GameUtil.getImage("com/example/snake/food-strawberry.png"));
		images.put("16", GameUtil.getImage("com/example/snake/food-watermelon.png"));
		images.put("UI-background", GameUtil.getImage("com/example/snake/UI-background.png"));
		images.put("game-scene-01", GameUtil.getImage("com/example/snake/game-scene-01.jpg"));
	}
}