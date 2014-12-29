import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Body {
	private Point start;
	private Point center;
	private int width;
	private int height;
	private Color color;
	private int speedX;
	private int speedY;
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
//////
	public Body(int x, int y, int width, int height, Color color, int speedX,
			int speedY, int minX, int minY, int maxX, int maxY) {
		start = new Point(x, y);
		center = new Point(x + (width / 2), y + (height / 2));
		this.width = width;
		this.height = height;
		this.color = color;
		this.speedX = speedX;
		this.speedY = speedY;
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}

	public void draw(Graphics g) {
		move();
		g.setColor(color);
		return;
	}

	public Point getStart() {
		return start;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return start.getX();
	}

	public int getY() {
		return start.getY();
	}

	public boolean checkCollision(Body other) {
		int distance = this.center.getDistance(other.center);
		if (distance > (this.height / 2) + (other.height / 2)
				&& (distance > (this.width / 2) + (other.width / 2)))
			return false;
		return true;
	}

	private void move() {
		if (this.start.getX() + this.width + speedX >= maxX && speedX > 0){
			speedX = 0;
			start.setX(maxX - width); 
		}
		if (this.start.getX() + speedX <= minX && speedX < 0){
			speedX = 0;
			start.setX(minX );
		}
		if (this.start.getY() + this.height + speedY >= maxY && speedY > 0){
			speedY = 0;
			start.setY(maxY-height); 
			
		}
		if (this.start.getY() + speedY <= minY && speedY < 0){
			speedY = 0;
			start.setY(minY);
		}
		System.out.println(speedX);
		this.start.move(speedX, speedY);
		this.center.move(speedX, speedY);
	}
	
	public void jump(){
		if(start.getY() == maxY-height){
		speedY = -5; 
		Timer t = new Timer (1000, new JumpHandler());
		t.start();
		}
	}
	
	public void reset(){
		if(this.start.getX() + speedX <= minX){
			this.start.setX(maxX);
			this.center.setX(maxX + width/2); 
		}
	}
	
	private class JumpHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			speedY = 5;
			Timer t = (Timer)(e.getSource());
			t.stop();
		}
		
	}
	

	
}
