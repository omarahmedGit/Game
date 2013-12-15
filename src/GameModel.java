

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;


public class GameModel implements ReadOnlyGameModel, UpdateGameModelInfc{
	private Player player1;
	private Player player2;
	private Belt topRightBelt;
	private Belt topLeftBelt;
	private ShapesPool pool;
	private FallingArea fall;
	private Dimension gameDimension;
	Shape s; // bassem test
	public GameModel(String loadedGame, Dimension screenSize) { 
		// el string 3lma mesh aktar mesh 3aref 7ewar el save da lessa 
	}
	public GameModel(Dimension screenSize) {
		s=new Shape1(Color.black,50,50);
		setDimension(screenSize);
		int p1x=(screenSize.width/8);
		int p2x=(screenSize.width/8)*6;
		int py =(screenSize.height/4)*3;
		setPlayer1(new Player(p1x,py,1,this));
		setPlayer2(new Player(p2x,py,2,this));        
		setRightBelt(new RightBelt(getScreenSize().width,(getScreenSize().width*3)/4, this));
		setLeftBelt(new LeftBelt(0,getScreenSize().width/4, this));
		setShapesPool(new ShapesPool());
		setFallingArea(new FallingArea(this));
	}
	
	public Dimension getScreenSize() {return gameDimension;}
	public Player getPlayer1() {return player1;}
	public Player getPlayer2() {return player2;}
	public Belt	getRightBelt() {return topRightBelt;}
	public Belt	getLeftBelt()  {return  topLeftBelt;}
	public ShapesPool getShapesPool() {return pool;}
	public FallingArea getFallingArea() {return fall;}
	
	public void setDimension(Dimension dimension){gameDimension = dimension;}
	public void setPlayer1(Player player){player1 = player;}
	public void setPlayer2(Player player){player2 = player;}
	public void setRightBelt(Belt belt) {topRightBelt = belt;}
	public void setLeftBelt(Belt belt) {topLeftBelt = belt;}
	public void setShapesPool(ShapesPool pool) {this.pool = pool;}
	public void setFallingArea(FallingArea fall){this.fall =fall;}
	
	public void updatePlayer1(int x){
		getPlayer1().updateByKeyBoard(x);
	}
	public void updatePlayer2(int x){
		getPlayer2().updateByMouse(x);
	}
	public void update()
	{
		getRightBelt().addShapesToBelt();
		getLeftBelt().addShapesToBelt();
		getRightBelt().moveShapes();
		getLeftBelt().moveShapes();
		getFallingArea().getIntoAction();
	}
	@Override
	public ArrayList<Drawable> getShapesArray() {
		ArrayList<Drawable> drawingList=new ArrayList<Drawable>();
		drawingList.add(getPlayer1());
		drawingList.add(getPlayer2());
		drawingList.add(getRightBelt());
		drawingList.add(getLeftBelt());
		drawingList.add(getFallingArea());
		return drawingList;
	}
	
	
}
