
import java.awt.Color;
import java.awt.Graphics;


public class Shape implements Drawable{
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
	
	/* 
	 * every shape has [as i think] 7 states
	 * 1- in the pool and not visual on the screen
	 * 2- on the line belt
	 * 3- falling in free motion
	 * 4- a player hold it 
	 * 		a) with player1 right hand 4
	 * 		b) with player1 left  hand 5
	 * 		c) with player2 right hand 6
	 * 		d) with player2 left  hand 7
	 */
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

		setCurrentState(getNotVisual());
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
	public void setCurrentState(ShapeState state){currentState = state;}
	
	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
