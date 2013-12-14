package View;

import java.awt.Graphics;

import javax.sound.midi.ControllerEventListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

import ModelandControl.GameModel;
import ModelandControl.ReadOnlyGameModel;
import ModelandControl.Updator;




public class GameView extends JComponent implements Runnable{
	
	ReadOnlyGameModel gameModel;
	Thread gameThread;
	boolean running;
	
	public GameView(ReadOnlyGameModel model ,Updator control) {
		gameModel=  model;
		gameThread=new Thread(this);
		running=true;
	}

	public void run() {
		// TODO Auto-generated method stub
		while(running){
			
			repaint();
			try {
				gameThread.sleep(1000);
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
