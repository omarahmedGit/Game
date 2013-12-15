import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MyKeyListner extends KeyAdapter{
	GameView gameView;
	public MyKeyListner(GameView GV){
		gameView=GV;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode=e.getKeyCode();
		if (keyCode==KeyEvent.VK_LEFT){
			gameView.arrowPressed(-5);			
		}else if(keyCode==KeyEvent.VK_RIGHT){
			gameView.arrowPressed(5);
		}
		else if (keyCode==KeyEvent.VK_ESCAPE){
			
		}
	}

}
