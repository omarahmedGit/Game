

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;


public class GameModel implements ReadOnlyGameModel, UpdateGameModelInfc{
	Player player1;
	Player player2;
	Belt rightBelt;
	Belt leftBelt;
	ShapesPool pool;
	FallingArea fall;
	Dimension gameDimension;
	Shape s; // bassem test
	public GameModel(String loadedGame, Dimension screenSize) { 
		// el string 3lma mesh aktar mesh 3aref 7ewar el save da lessa 
	}
	public GameModel(Dimension screenSize) {
		s=new Shape1(Color.black,50,50,50,50);
		gameDimension = screenSize;
		player1   = new Player(1,this); // early assumptions for the parameters
		player2   = new Player(2,this);
		rightBelt = new Belt(700,1000, this); // some thing like that on the screen
		leftBelt  = new Belt(0,300, this);  // [0]---------------[10]               [20]---------------[30]//         
		pool = new ShapesPool();
		fall = new FallingArea(this);
		
	}
	
	public Dimension getScreenSize() {return gameDimension;}
	
	public void update(int x1,int y1, int x2,int y2)
	{
		/*		// observer gonna be used when updating the player position then update all plates he holds position  
		 * 		1) adding shapes to the belt
		 * 		2) move every shape on the belt into it's direction
		 * 		3) check if the things on the belt gonna fall down 
		 * 		4) then check if a shape gonna be in the players hand
		 * 		5) check if the shapes gonna go down and then added to the pool
		 */
		
		rightBelt.addShapesToBelt();
		leftBelt.addShapesToBelt();
		rightBelt.moveShapes();
		leftBelt.moveShapes();
		fall.getIntoAction();	// in it there gonna be check if the player catch it and if it fall of the screen ->pool
		
		
	}
	@Override
	public ArrayList<Drawable> getShapesArray() {
		// TODO Auto-generated method stub
//		returns all things that must be drawn(implements Drawable) in an arraylist
//		test test
		
		ArrayList<Drawable> d=new ArrayList<Drawable>();
		d.add(s);
		return d;
	}
//	
	@Override
	public void updateShapePos(int x, int y) {
		// TODO Auto-generated method stub
		s.posX=s.posX+x;
		s.posY=s.posY+y;
	}
	
	
}
