import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class GameView extends JComponent implements Runnable{
	
	private ReadOnlyGameModel gameModel;
	private Updator gameControl;
	private Thread gameThread;
	private boolean isRunning;
	private MyMenu2 myMenu;
	private Image winImage;
	private Image player1meme;
	private Image player2meme;
	private Image bk;
	private boolean winnerExist;
	private int maxScore;
	
	
	public GameView(ReadOnlyGameModel model ,Updator control) {
		gameModel=  model;
		gameControl =control;
		gameThread=new Thread(this);
		isRunning=true;
		winnerExist=false;
		maxScore=gameControl.getMaxScore();
		winImage=(new ImageIcon("winner.png")).getImage();
		player1meme=(new ImageIcon("player1win.png")).getImage();
		player2meme=(new ImageIcon("player2win.png")).getImage();
		bk=(new ImageIcon("background.jpg")).getImage();
	    this.setFocusable(true);
	    this.requestFocus();
		this.addKeyListener(new MyKeyListner(this));
		this.addMouseMotionListener(new MyMouseListener(this));
		myMenu=new MyMenu2(this);
		gameThread.start();
		
	}

	public void run() {
		// TODO Auto-generated method stub
		while(isRunning){
			if (gameModel.playerOneLose() || gameModel.playertwoLose() ){
				pause();
				winnerExist=true;
			}
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
	private void paintWinner(Graphics g){
		if (gameModel.playerOneLose()){
			drawPlayer2win(g);
			showMenu(true);
		}
		else if (gameModel.playertwoLose()){
			drawPlayer1win(g);
			showMenu(true);
			
		}
		if (gameControl.checkWinningPlayer1()){
			drawPlayer1win(g);
			pause();
			showMenu(true);
		}
		if (gameControl.checkWinningPlayer2() ){
			drawPlayer2win(g);
			pause();
			showMenu(true);
			}
		
	}
		private void drawPlayer1win(Graphics g){
			g.drawImage(winImage, gameModel.getScreenDim().width/6, 
					gameModel.getScreenDim().height/8,gameModel.getScreenDim().width/3,gameModel.getScreenDim().height/2, null);
			g.drawImage(player1meme, gameModel.getScreenDim().width/2, 
					gameModel.getScreenDim().height/8,gameModel.getScreenDim().width/3,gameModel.getScreenDim().height/2, null);
		}
		private void drawPlayer2win(Graphics g){
			g.drawImage(player2meme, gameModel.getScreenDim().width/2, 
					gameModel.getScreenDim().height/8,gameModel.getScreenDim().width/3,gameModel.getScreenDim().height/2, null);

			g.drawImage(winImage, gameModel.getScreenDim().width/6, 
					gameModel.getScreenDim().height/8,gameModel.getScreenDim().width/3,gameModel.getScreenDim().height/2, null);
			
	}
	public void paintComponent(Graphics g){
		g.drawImage(bk, 0,0,gameModel.getScreenDim().width, gameModel.getScreenDim().height,null);
		for (int i = 0; i < gameModel.getShapesArray().size(); i++) {
			gameModel.getShapesArray().get(i).drawShape(g);
		}
		paintWinner(g);
		g.drawImage(player2meme,gameModel.getScreenDim().width/2 -15 , 10,gameModel.getScreenDim().width/20,gameModel.getScreenDim().height/15, null);
		g.drawImage(player1meme,gameModel.getScreenDim().width/2 -80 , 10,gameModel.getScreenDim().width/20,gameModel.getScreenDim().height/15, null);
		g.drawString(gameModel.getPlayer1Score()+"/"+maxScore,gameModel.getScreenDim().width/2 -50 , 80);
		g.drawString(gameModel.getPlayer2Score()+"/"+maxScore,gameModel.getScreenDim().width/2 +25 , 80);
	}
	public void arrowPressed(int i){
		gameControl.updatePlayer1KeyBoard(i);
	}

	public void mouseMoved(int x) {
		// TODO Auto-generated method stub
		gameControl.updatePlayer2Mouse(x);
		
	}

	public void pauseGame() {
		// TODO Auto-generated method stub
		if(isRunning){
			pause();
			this.showMenu(false);
			System.out.println("111111111111");
		}
		else{
			myMenu.setVisible(false);
			System.out.println("22222222222222222");

		}
		
	}
	
	private void pause(){
		isRunning=false;
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



	public GameModel getGameModel() {
		// TODO Auto-generated method stub
		return (GameModel) gameModel;
	}
	public void showMenu(boolean b){
		myMenu.setBounds(b);
		myMenu.setVisible(true);
		
	}

}
