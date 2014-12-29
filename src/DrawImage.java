import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class DrawImage extends Body {

	private Image image;
	
	public DrawImage(int x, int y, int width, int height,
			int speedX, int speedY, String path) {
		super(x, y, width, height, null, speedX, speedY, speedY, speedY, speedY, speedY);
		image = load(path);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawImage(image, super.getX(), super.getY(), super.getWidth(), super.getHeight(), null);
	}
	
	private static Image load(String path) {
        try {
        	InputStream is = DrawImage.class.getResourceAsStream(path);
        	Image img = ImageIO.read(is);
            return img;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
