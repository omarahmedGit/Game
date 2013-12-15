import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;


public class Player implements Drawable , PlayerObserver {
	private PlayerHand righthand;
	private PlayerHand lefthand;
	private int posX; // top left X
	private int posY; // top left Y
	private int id;
	private int score;
	private int height, width;
	private String name;
	private GameModel gameModel;
	Image image;
	
	public Player(int x,int y,int ID, GameModel gameModel) {
		setID(ID);
		setScore(0);
		setGameModel(gameModel);
		setWidth(gameModel.getScreenSize().width/8);
		setHeight(gameModel.getScreenSize().height/4);
		setPosX(x);
		setPosY(y);
		setRightHand(new PlayerHand(this, (getPosX() + getPosX()*2/3)));
		setLeftHand(new PlayerHand(this, getPosX()));
		
		ImageIcon i=new ImageIcon("p"+ID+".png");
		image=i.getImage();
	}
	
	public void setPosX(int x){ posX = x;}
	public void setPosY(int y){ posY = y;}
	public void setID(int ID) { id  = ID;}
	public void setScore(int score) {this.score = score;}
	public void setName(String name) {this.name = name;}
	public void setHeight(int height) {this.height = height;}
	public void setWidth(int width) {this.width = width;}
	public void setRightHand(PlayerHand hand){righthand = hand;}
	public void setLeftHand(PlayerHand hand){lefthand   = hand;}
	public void setGameModel(GameModel game){this.gameModel = game;}
	
	
	public int getPosX(){ return  posX;}
	public int getPosY(){return posY;}
	public int getID(){ return id;}
	public int getRightHandSize() {return righthand.getHandSize();}
	public int getLefttHandSize() {return lefthand.getHandSize();}
	public int getScore() {return score;}
	public String getName() {return name;}
	public PlayerHand getRightHand() {return righthand;}
	public PlayerHand getLeftHand() {return lefthand;}
	public int getHeight() {return height;}
	public int getWidht()  {return 	width;}
	public GameModel getGameModel(){return gameModel;}
	
	public void updateMovement(int newX)
	{
		getRightHand().setXPos(getRightHand().getXPos()+newX);
		getLeftHand().setXPos(getLeftHand().getXPos()+newX);
		Iterator<Shape> itr = getRightHand().createIterator();
		while(itr.hasNext())
		{
			Shape temp = itr.next();
			temp.updateShape(newX);
		}
		itr = getLeftHand().createIterator();
		while(itr.hasNext())
		{
			Shape temp = itr.next();
			temp.updateShape(newX);
		}
	}
	
	public void updateByMouse(int x)
	{
		setPosX(x);
	}
	
	public void updateByKeyBoard(int x)
	{
		setPosX(getPosX()+x);
	}
	
	public void addShapeToRightHand(Shape a)
	{
		getRightHand().addShape(a);
	}
	
	public void addShapeToLeftHand(Shape a)
	{
		getLeftHand().addShape(a);
	}
	
	public void incrementPlayerScore() {setScore(getScore()+1);}

	@Override
	public void drawShape(Graphics g) {
		g.drawImage(image, posX,posY,width,height,null);
		getRightHand().drawShape(g);
		getLeftHand().drawShape(g);
	}
}
