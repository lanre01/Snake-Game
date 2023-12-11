package com.example.snakeGame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.SnapshotParameters;
import javafx.scene.paint.Color;
import java.util.Objects;

public class GameUtil {
	public GameUtil() {
	}

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



	public static Image rotateImage(Image image, int degree) {
		ImageView imageView = new ImageView(image);
		imageView.setRotate(degree);

		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);

        return imageView.snapshot(params, null);







		/*int w = bufferedImage.getWidth();
		int h = bufferedImage.getHeight();
		int t = bufferedImage.getColorModel().getTransparency();
		BufferedImage i;
		Graphics2D graphics2d;
		(graphics2d = (i = new BufferedImage(w, h, t)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.rotate(Math.toRadians((double)degree), (double)(w / 2), (double)(h / 2));
		graphics2d.drawImage(bufferedImage, 0, 0, (ImageObserver)null);
		graphics2d.dispose();
		return i;*/
	}
}