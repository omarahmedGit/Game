package ModelandControl;

import java.awt.Dimension;
import java.util.ArrayList;


public class GameModel implements ReadOnlyGameModel{
	Player player1;
	Player player2;
	Belt rightBelt;
	Belt leftBelt;
	ShapesPool pool;
	FallingArea fall;
	public GameModel(String loadedGame,Dimension screenSize) { // el string 3lma mesh aktar mesh 3aref 7ewar el save da lessa 
		// TODO Auto-generated constructor stub
	}
	public GameModel(Dimension screenSize) { // screen size to make all dimensions realtive to it
		player1   = new Player(-10, 0, 1,this); // early assumptions for the parameters
		player2   = new Player( 10, 0, 2,this);
		rightBelt = new Belt(20,30); // some thing like that on the screen
		leftBelt  = new Belt(0,10);  // [0]---------------[10]               [20]---------------[30]//         
		pool = new ShapesPool();
		fall = new FallingArea();
	}
	
	public void update()
	{
		
		
		
		
	}
	@Override
	public ArrayList<Drawable> getShapesArray() {
		// TODO Auto-generated method stub
//		returns all things that must be drawn(implements Drawable) in an arraylist
		return null;
	}
	
	
}
