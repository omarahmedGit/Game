import java.awt.Graphics;

import javax.swing.JComponent;

public class GameView extends JComponent implements Runnable{
	
	ReadOnlyGameModel gameModel;
	Updator gameControl;
	Thread gameThread;
	boolean running;
	
	public GameView(ReadOnlyGameModel model ,Updator control) {
		gameModel=  model;
		gameControl =control;
		gameThread=new Thread(this);
		running=true;
		gameThread.start();
		
	}

	public void run() {
		// TODO Auto-generated method stub
		while(running){
			
			repaint();
			gameControl.update();
			try {
				gameThread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	@Override
	public void paintComponent(Graphics g){
		for (int i = 0; i < gameModel.getShapesArray().size(); i++) {
			gameModel.getShapesArray().get(i).drawShape(g);
		}
	}

	
}
