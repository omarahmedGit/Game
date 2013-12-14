import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Player implements Drawable{
	PlayerHand righthand;
	PlayerHand lefthand;
	private int posX; // top left X
	private int posY; // top left Y
	private int id;
	private int score;
	private int height, width;
	String name;
	GameModel gameModel;
	Image image;
	
	public Player(int x,int y,int ID, GameModel gameModel) {
		id = ID ;
		score = 0;
		this.gameModel = gameModel;
		width=gameModel.getScreenSize().width/8;
		height=gameModel.getScreenSize().height/4;
		posX = x;
		posY = y;
//		setDimension();
		righthand = new PlayerHand(this, (getPosX() + getPosX()*2/3));
		lefthand = new PlayerHand(this, getPosX());
		
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
	
//	private void setDimension()
//	{
//		setWidth(gameModel.getScreenSize().width/8);
//		setHeight(gameModel.getScreenSize().height/4);
//		if(id==1)
//		{
//			setPosY(gameModel.getScreenSize().height-(gameModel.getScreenSize().height/4));
//			setPosX((gameModel.getScreenSize().width/2)+(gameModel.getScreenSize().width/2 - getWidht())/2);
//		}
//		else
//		{
//			setPosY(gameModel.getScreenSize().height-(gameModel.getScreenSize().height/4));
//			setPosX((gameModel.getScreenSize().width/2 - getWidht())/2);			
//		}
//	}
	
	public void addShapeToRightHand(Shape a)
	{
		righthand.addShape(a);
	}
	
	public void addShapeToLeftHand(Shape a)
	{
		lefthand.addShape(a);
	}
	
	public void checkToRemovePlatesWithSameColor()
	{
		righthand.checkIfThreePlatesOfTheSameColor();
		lefthand.checkIfThreePlatesOfTheSameColor();
	}
	
	public void incrementPlayerScore() {setScore(getScore()+1);}

	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, posX,posY,width,height,null);
		
	}
}
