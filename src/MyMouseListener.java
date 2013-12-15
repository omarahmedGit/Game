import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MyMouseListener extends MouseAdapter{
	GameView gameView;
	public MyMouseListener(GameView GV){
		gameView=GV;
	}
	@Override
	public void mouseMoved(MouseEvent e){
		int x=e.getX();
		
		gameView.mouseMoved(x);
		System.out.println("mmmmmmmmmmmmmmmmm");
	}

}
