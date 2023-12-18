package com.example.snakeGame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.SnapshotParameters;
import javafx.scene.paint.Color;
import java.util.Objects;

/**
 * GameUtil is used to get any images, scenes that may be used in the game.
 * It also provides the rotateImage function to rotate images.
 */
public class GameUtil {
	/**
	 * No use
	 */
	public GameUtil() {
	}

	/**
	 * used to get an image from the resources folder in the JavaFx application.
	 * @param imagePath is the path of the image in the resource folder
	 * @return an image that is generated from the image in the resource folder
	 */
	public static Image getImage(String imagePath) {
		Image image = null;
		try {
			image = new Image(Objects.requireNonNull(GameUtil.class.getResourceAsStream(imagePath)));
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println(imagePath);
		}

		return  image;
	}


	/**
	 * It is used to rotate an image, specifically the snake head when arrow keys are pressed.
	 * @param image is the image that needs to be rotated.
	 * @param degree the amount of rotation that should be done.
	 * @return the rotated image.
	 */
	public static Image rotateImage(Image image, int degree) {
		ImageView imageView = new ImageView(image);
		imageView.setRotate(degree);

		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);

        return imageView.snapshot(params, null);
	}
}