

public class GameModel {
	Player player1;
	Player player2;
	Belt rightBelt;
	Belt leftBelt;
	ShapesPool pool;
	FallingArea fall;
	
	public GameModel() {
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
	
	
}
