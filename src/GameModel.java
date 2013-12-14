

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;


public class GameModel implements ReadOnlyGameModel, UpdateGameModelInfc{
	private Player player1;
	private Player player2;
	private Belt rightBelt;
	private Belt leftBelt;
	private ShapesPool pool;
	private FallingArea fall;
	private Dimension gameDimension;
	Shape s; // bassem test
	public GameModel(String loadedGame, Dimension screenSize) { 
		// el string 3lma mesh aktar mesh 3aref 7ewar el save da lessa 
	}
	public GameModel(Dimension screenSize) {
		s=new Shape1(Color.black,50,50,50,50);
		setDimension(screenSize);
		int p1x=(screenSize.width/8);
		int p2x=(screenSize.width/8)*6;
		int py =(screenSize.height/4)*3;
		setPlayer1(new Player(p1x,py,1,this));
		setPlayer2(new Player( p2x,py, 2,this));        
		setRightBelt(new Belt(700,1000, this));
		setLeftBelt(new Belt(0,300, this));
		setShapesPool(new ShapesPool());
		setFallingArea(new FallingArea(this));
	}
	
	public Dimension getScreenSize() {return gameDimension;}
	public Player getPlayer1() {return player1;}
	public Player getPlayer2() {return player2;}
	public Belt	getRightBelt() {return rightBelt;}
	public Belt	getLeftBelt()  {return  leftBelt;}
	public ShapesPool getShapesPool() {return pool;}
	public FallingArea getFallingArea() {return fall;}
	
	public void setDimension(Dimension dimension){gameDimension = dimension;}
	public void setPlayer1(Player player){player1 = player;}
	public void setPlayer2(Player player){player2 = player;}
	public void setRightBelt(Belt belt) {rightBelt = belt;}
	public void setLeftBelt(Belt belt) {leftBelt = belt;}
	public void setShapesPool(ShapesPool pool) {this.pool = pool;}
	public void setFallingArea(FallingArea fall){this.fall =fall;}
	
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
//		returns all things that must be drawn(implements Drawable) in an arraylist
//		test test
		ArrayList<Drawable> d=new ArrayList<Drawable>();
		d.add(s);
		d.add(player1);
		d.add(player2);
		return d;
	}
//	
	@Override
	public void updateShapePos(int x, int y) {
		// TODO Auto-generated method stub
//		s.posX=s.posX+x;
//		s.posY=s.posY+y;
	}
	
	
}
