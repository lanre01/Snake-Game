package com.example.snakeGame;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;

/**
 * This class stores the images needed during the game in a HashMap.
 * The hashMap can be accessed using either numbers or phrases depending on how it is stored.
 */
public class ImageUtil {

	/**
	 * The hashMap that stores the images.
	 */
	public static Map<String, Image> images = new HashMap<>();

	/**
	 * No use
	 */
	public ImageUtil() {
	}

	static {
		images.put("snake-head-right", GameUtil.getImage("Snake/snake-head-right.png"));
		images.put("snake-body", GameUtil.getImage("Snake/snake-body.png"));
		images.put("0", GameUtil.getImage("Foods/food-apple.png"));
		images.put("1", GameUtil.getImage("Foods/food-lemon.png"));
		images.put("2", GameUtil.getImage("Foods/food-litchi.png"));
		images.put("3", GameUtil.getImage("Foods/food-mango.png"));
		images.put("4", GameUtil.getImage("Foods/food-apple.png"));
		images.put("5", GameUtil.getImage("Foods/food-banana.png"));
		images.put("6", GameUtil.getImage("Foods/food-blueberry.png"));
		images.put("7", GameUtil.getImage("Foods/food-cherry.png"));
		images.put("8", GameUtil.getImage("Foods/food-durian.png"));
		images.put("9", GameUtil.getImage("Foods/food-grape.png"));
		images.put("10", GameUtil.getImage("Foods/food-grapefruit.png"));
		images.put("11", GameUtil.getImage("Foods/food-peach.png"));
		images.put("12", GameUtil.getImage("Foods/food-pear.png"));
		images.put("13", GameUtil.getImage("Foods/food-orange.png"));
		images.put("14", GameUtil.getImage("Foods/food-pineapple.png"));
		images.put("15", GameUtil.getImage("Foods/food-strawberry.png"));
		images.put("16", GameUtil.getImage("Foods/food-watermelon.png"));
		images.put("UI-background", GameUtil.getImage("Scenes/UI-background.png"));
		images.put("game-scene-01", GameUtil.getImage("Scenes/game-scene-01.jpg"));
	}
}