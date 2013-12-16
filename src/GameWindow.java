import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class GameWindow extends JFrame{
	
	private static GameWindow gameWindow;
	private GameWindow(){

	}
	public static GameWindow makeGameWindow(GameView gameView){
			System.out.println("bassem");
			gameWindow=new GameWindow();
			gameWindow.add(gameView);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			gameWindow.setSize(screenSize);
			gameWindow.setLocationRelativeTo(null);
			gameWindow.setUndecorated(true);
			gameWindow.setVisible(true);
//		}
//		System.out.println("bosssaa");
		return gameWindow;
	}

	public static void closeGameWindow(){
		gameWindow.dispose();
	}
}
