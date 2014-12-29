import javax.swing.JFrame;
import javax.swing.JPanel;

public class Play extends JPanel {
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Jumper");
		frame.setSize(500, 500);
		frame.setLocation(1000, 200);
		GameGraphics gg = new GameGraphics(500, 500);
		frame.setContentPane(gg);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
		gg.requestFocus(false);
	}
}
// action listener treba da reaguje na promjenu sirine prozora mijenja se
// iscrtavanje
//