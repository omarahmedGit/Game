
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Shape implements Drawable , ShapeObserver{
	private Color c = Color.BLACK;
	private int posX;	// center X
	private int posY;	// center Y
	private int widthRadius; //width
	private int heightRadius;
	
	private ShapeState falling;
	private ShapeState onTheLine;
	private ShapeState withPlayer;
	private ShapeState notVisual;
	private ShapeState currentState;
	public Shape(){
		
	}
	public Shape(Color c,int x,int y,int widthradius, int heightradius) {
		setColor(c);
		setPostionX(x);
		setPostionY(y);
		setWidthRedius(widthradius);
		setHeightRedius(heightradius);
		setFalling(new ShapeFalling(this));
		setNotVisual(new ShapeNotVisual(this));
		setWithPlayer(new ShapeWithPlayer(this));
		setShapeOnTheLine(new ShapeOnTheLine(this));
		setShapeState(getNotVisual());
	}
	
	
	public int getPostionX() { return posX;}
	public int getPostionY() { return posY;}
	public int getWidthRadius() 	{return  widthRadius;}
	public int getHeightRadius() 	{return heightRadius;}
	public Color getColor()  { return 	 c;}
	public ShapeState getFalling()		{return 	falling;}
	public ShapeState getOnTheLine()	{return   onTheLine;}
	public ShapeState getWithPlayer()	{return  withPlayer;}
	public ShapeState getNotVisual()	{return   notVisual;}	
	public ShapeState getCurrentState()	{return   currentState;}	
	
	
	public void setPostionX(int x) { posX = x;}
	public void setPostionY(int y) { posY = y;}
	public void setColor(Color color)  { c = color ;}
	public void setShapeState(ShapeState newShapeState) {currentState = newShapeState;}
	public void setWidthRedius(int w){widthRadius = w;}
	public void setHeightRedius(int h){heightRadius = h;}
	public void setFalling(ShapeFalling fall) {falling = fall;}
	public void setShapeOnTheLine(ShapeOnTheLine state){onTheLine = state;}
	public void setWithPlayer(ShapeWithPlayer state){withPlayer = state;}
	public void setNotVisual(ShapeNotVisual state){notVisual = state;}
	
	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getPostionX()-getWidthRadius(), getPostionY()-getHeightRadius(), getWidthRadius()*2, getHeightRadius()*2);
	}
	@Override
	public void updateShape(int newX) {
		setPostionX(getPostionX()+newX);
	}
}
