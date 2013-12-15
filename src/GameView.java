import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class GameView extends JComponent implements Runnable{
	
	private ReadOnlyGameModel gameModel;
	private Updator gameControl;
	private Thread gameThread;
	private boolean isRunning;
//	private MyMenu2 myMenu;
	
	public GameView(ReadOnlyGameModel model ,Updator control) {
		gameModel=  model;
		gameControl =control;
		gameThread=new Thread(this);
		isRunning=true;
	    this.setFocusable(true);
	    this.requestFocus();
		this.addKeyListener(new MyKeyListner(this));
		this.addMouseMotionListener(new MyMouseListener(this));
//		myMenu=new MyMenu2(this);
		gameThread.start();
		
	}

	public void run() {
		// TODO Auto-generated method stub
		while(isRunning){
			
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

	public void ShowMenu() {
		// TODO Auto-generated method stub
		if(isRunning){

			pause();
			System.out.println("111111111111");
		}
		else{
//			myMenu.setVisible(false);
			System.out.println("22222222222222222");

		}
		
	}
	
	private void pause(){
		isRunning=false;
//		myMenu.setVisible(true);
		try {
			gameThread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	public void resume(){
		isRunning = true;
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void loadShape(Class loadClass) {
		// TODO Auto-generated method stub
//		gameControl.loadShape(loadClass);
	}

}
