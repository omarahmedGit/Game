package View;
import javax.swing.JComponent;

import Control.GameControler;


public class GameView  implements Runnable{
	
	public GameView() {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			GameControler.update();
		}
		
	}
	
}
