

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AudioPlayer02.main(null, "sound.wav");
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					MainWindow frame = new MainWindow(screenSize);
					frame.setSize(screenSize);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
