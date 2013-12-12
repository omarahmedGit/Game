import java.util.Stack;


public class Player {
	Stack<Shape> righthand;
	Stack<Shape> lefthand;
	int posX;
	int posY;
	int id;
	
	public Player(int x ,int y, int ID) {
		posX = x;
		posY = y;
		id = ID ;
		righthand = new Stack<Shape>();
		lefthand = new Stack<Shape>();
	}
	
	public void setPosX(int x){ posX = x;}
	public void setPosY(int y){ posY = y;}
	public void setID(int ID) { id  = ID;}
	
	public int getPosX(){ return  posX;}
	public int getPosY(int x){return posY;}
	public int getID(){ return id;}
	public int getRightHandStackSize() {return righthand.size();}
	public int getLeftHandStackSize()  {return lefthand.size(); }
	
	// function bet5od tab2 w t7oto f 2id el wad sawa2 el lemen 2w el shemal 
	
	public void addShapeToRightHand(Shape a)
	{
		righthand.add(a);
		// then check if there is a three paltes with the same color
	}
	
	public void addShapeToLeftHand(Shape a)
	{
		lefthand.add(a);
		// then check if there is a three paltes with the same color
	}
	
	
}
