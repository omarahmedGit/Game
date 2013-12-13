

public class GameModel {
	Player player1;
	Player player2;
	Belt rightBelt;
	Belt leftBelt;
	ShapesPool pool;
	FallingArea fall;
	
	public GameModel() {
		player1 = new Player(-10, 0, 1); // early assumptions for the parameters
		player2 = new Player( 10, 0, 2);
		rightBelt = new Belt(20,30); // some thing like that
		leftBelt = new Belt(0,10);   // [0]---------------[10]               [20]---------------[30]//         
		pool = new ShapesPool();
		fall = new FallingArea();
	}
	
	
	public void update()
	{
		/*
		 * clean enough :D
		 */
	}
	
	
}
