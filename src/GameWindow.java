import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class GameWindow extends JFrame{
	


	public GameWindow(GameView gameView) {
		// TODO Auto-generated constructor stub
		this.add(gameView);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
	}

}
