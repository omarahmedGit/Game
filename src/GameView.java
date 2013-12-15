import java.awt.Graphics;
import java.awt.Graphics2D;

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
	    this.setFocusable(true);
	    this.requestFocus();
		this.addKeyListener(new MyKeyListner(this));
		this.addMouseMotionListener(new MyMouseListener(this));
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
	public void paintComponent(Graphics g){
		for (int i = 0; i < gameModel.getShapesArray().size(); i++) {
			gameModel.getShapesArray().get(i).drawShape(g);
		}
	}
	public void arrowPressed(int i){
		gameControl.updatePlayer1KeyBoard(i);
	}

	public void mouseMoved(int x) {
		// TODO Auto-generated method stub
		gameControl.updatePlayer2Mouse(x);
		
	}
	
}
