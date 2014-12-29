import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Body {

	public Oval(int x, int y, int width, int height, Color color, int speedX,
			int speedY, int minX, int maxX, int minY, int maxY) {
		super(x, y, width, height, color, speedX, speedY, minX, maxX, minY,
				maxY);

	}

	public void draw(Graphics g) {
		super.draw(g);
		g.fillOval(super.getX(), super.getY(), super.getWidth(),
				super.getHeight());
	}

}
