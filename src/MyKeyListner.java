import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MyKeyListner extends KeyAdapter{
	GameView gameView;
	public MyKeyListner(GameView GV){
		gameView=GV;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode=e.getKeyCode();
		if (keyCode==KeyEvent.VK_LEFT){
			gameView.arrowPressed(1);
			System.out.println("gggggg");
			
		}else if(keyCode==KeyEvent.VK_RIGHT){
			gameView.arrowPressed(-1);
			System.out.println("hhhhhhhhh");
		}
		else if (keyCode==KeyEvent.VK_ESCAPE){
			
		}
	}

}
