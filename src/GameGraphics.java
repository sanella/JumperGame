import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

public class GameGraphics extends JPanel implements ActionListener {
	private Timer animation;
	Body[] elements;
	int elementCount;
	int width;
	int height;

	
	private Body player;
	
	
	
	public GameGraphics(int width, int height) {
		super();
		animation = new Timer(17, this);
		elements = new Body[10];
		//elementCount = 0;
		// ovo smo stavili radi debuging-a
		
		player = new Oval(250, height - 100-30, 20, 30, Color.RED, 0, 0, 0, 0, 500, 400);
		animation.start();
		this.width = width;
		this.height = height;
		addKeyListener(new KeeyHandler());
		for (int i = 0; i < elements.length; i++) {
			elements[i] = new Oval(450 + (int)(Math.random() * 100), height - 100, (int)(Math.random() * 50), (int)(Math.random() * 100), Color.BLACK, (int)(Math.random()*-5), 3, -10, 0, 500, 400);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(184, 242, 245));
		g.setColor(new Color(54, 140, 22));
		g.fill3DRect(0, height - 100, width + 1000, height, true);
		player.draw(g);
		for (int i = 0; i < elements.length; i++) {
			elements[i].draw(g);
			
			if(player.checkCollision(elements[i])){
				
				animation.stop();
				JOptionPane.showMessageDialog(null,  "Izbubio si","Proozr", JOptionPane.ERROR_MESSAGE);
				break;
			
			}
			elements[i].reset();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	private class KeeyHandler extends KeyAdapter{
		
		public void keyTyped(KeyEvent k){
			player.jump();
			System.out.println(k.getKeyCode());
		}
	}
}
// treba imat set width i setHeight zbog promjene prozora
