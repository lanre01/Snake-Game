package com.example.snakeGame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.imageio.ImageIO;

public class GameUtil {
	public GameUtil() {
	}

	public static Image getImage(String imagePath) {
		URL u = GameUtil.class.getClassLoader().getResource(imagePath);

		BufferedImage i = null;

		try {
			i = ImageIO.read(u);
		} catch (Exception e) {
			System.err.println("ERROR : IMAGE NOT FOUND !\n");
			System.err.println(imagePath);
			//e.printStackTrace();
		}

		return i;
	}



	public static Image rotateImage(BufferedImage bufferedImage, int degree) {
		int w = bufferedImage.getWidth();
		int h = bufferedImage.getHeight();
		int t = bufferedImage.getColorModel().getTransparency();
		BufferedImage i;
		Graphics2D graphics2d;
		(graphics2d = (i = new BufferedImage(w, h, t)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.rotate(Math.toRadians((double)degree), (double)(w / 2), (double)(h / 2));
		graphics2d.drawImage(bufferedImage, 0, 0, (ImageObserver)null);
		graphics2d.dispose();
		return i;
	}
}