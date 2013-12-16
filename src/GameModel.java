

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;


public class GameModel implements ReadOnlyGameModel, UpdateGameModelInfc,Serializable{
	private Player player1;
	private Player player2;
	private Belt topRightBelt;
	private Belt topLeftBelt;
	private Belt lowerRightBelt;
	private Belt lowerLeftBelt;
	private ShapesPool pool;
	private FallingArea fall;
	private Dimension gameDimension;
//	Shape s; // bassem test
	public GameModel(GameModel gameModel, Dimension screenSize) { 
		// el string 3lma mesh aktar mesh 3aref 7ewar el save da lessa 
		setDimension(screenSize);
		int p1x=(screenSize.width/8);
		int p2x=(screenSize.width/8)*6;
		int py =(screenSize.height/4)*3;
		setPlayer1(gameModel.getPlayer1());
		setPlayer2(gameModel.getPlayer2());        
		setRightBelt(gameModel.getTopRightBelt());
		setLeftBelt(gameModel.getTopLeftBelt());
		setLowerRightBelt(gameModel.getLowerRightBelt());
		setLowerLeftBelt(gameModel.getLowerLeftBelt());
		setShapesPool(gameModel.getShapesPool());
		setFallingArea(gameModel.getFallingArea());
	}
	public GameModel(Dimension screenSize) {
		setDimension(screenSize);
		int p1x=(screenSize.width/8);
		int p2x=(screenSize.width/8)*6;
		int py =(screenSize.height/4)*3;
		setPlayer1(new Player(p1x,py,1,this));
		setPlayer2(new Player(p2x,py,2,this));        
		setRightBelt(new RightBelt(getScreenSize().width,(getScreenSize().width*3)/4, this,getScreenSize().height/8));
		setLeftBelt(new LeftBelt(0,getScreenSize().width/4, this,getScreenSize().height/8));
		setLowerRightBelt(new RightBelt(getScreenSize().width,(getScreenSize().width*7)/8, this,getScreenSize().height/4));
		setLowerLeftBelt(new LeftBelt(0,getScreenSize().width/6, this,getScreenSize().height/4));
		setShapesPool(new ShapesPool());
		setFallingArea(new FallingArea(this));
	}
	
	public Dimension getScreenSize() {return gameDimension;}
	public Player getPlayer1() {return player1;}
	public Player getPlayer2() {return player2;}
	public Belt	getTopRightBelt() {return topRightBelt;}
	public Belt	getTopLeftBelt()  {return  topLeftBelt;}
	public Belt getLowerRightBelt() {return lowerRightBelt;}
	public Belt getLowerLeftBelt() {return lowerLeftBelt;}
	public ShapesPool getShapesPool() {return pool;}
	public FallingArea getFallingArea() {return fall;}
	
	public void setDimension(Dimension dimension){gameDimension = dimension;}
	public void setPlayer1(Player player){player1 = player;}
	public void setPlayer2(Player player){player2 = player;}
	public void setRightBelt(Belt belt) {topRightBelt = belt;}
	public void setLeftBelt(Belt belt) {topLeftBelt = belt;}
	public void setShapesPool(ShapesPool pool) {this.pool = pool;}
	public void setFallingArea(FallingArea fall){this.fall =fall;}
	public void setLowerRightBelt(Belt belt) {lowerRightBelt = belt;}
	public void setLowerLeftBelt(Belt belt) {lowerLeftBelt = belt;}
	
	
	public void updatePlayer1(int x){
		getPlayer1().updateByKeyBoard(x);
	}
	public void updatePlayer2(int x){
		getPlayer2().updateByMouse(x);
	}
	public void update()
	{
		getTopRightBelt().addShapesToBelt();
		getTopLeftBelt().addShapesToBelt();
		getLowerRightBelt().addShapesToBelt();
		getLowerLeftBelt().addShapesToBelt();
		
		getTopRightBelt().moveShapes();
		getTopLeftBelt().moveShapes();
		getLowerRightBelt().moveShapes();
		getLowerLeftBelt().moveShapes();
		
		getFallingArea().getIntoAction();
	}
	public void resetImages(){
		player1.resetImage();
		player2.resetImage();
	}
	@Override
	public ArrayList<Drawable> getShapesArray() {
		ArrayList<Drawable> drawingList=new ArrayList<Drawable>();
		drawingList.add(getPlayer1());
		drawingList.add(getPlayer2());
		drawingList.add(getTopRightBelt());
		drawingList.add(getTopLeftBelt());
		drawingList.add(getLowerLeftBelt());
		drawingList.add(getLowerRightBelt());
		drawingList.add(getFallingArea());
		return drawingList;
	}
	@Override
	public void addShape(Class loadClass) {
		// TODO Auto-generated method stub
		pool.addNewShape(loadClass);
	}
	
	
}
