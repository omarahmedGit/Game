
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;



public class FallingArea implements Drawable,ShapesIterator{
	ArrayList<Shape> fallingarea;
	GameModel game;
	private node[] moves = new node[2];
	public FallingArea(GameModel game) {
		fallingarea = new ArrayList<Shape>();
		setGameModel(game);
		moves[0] = new node(0 ,3);
	}
	
	public GameModel getGameModel() {return game;}
	public ArrayList<Shape> getShapesList() {return fallingarea;}
	
	public void setGameModel(GameModel game) {this.game=game;}
	
	public void getIntoAction() {
		Iterator<Shape> itr = createIterator();
		ArrayList<Shape> remove = new ArrayList<Shape>();
		while(itr.hasNext())
		{
			Shape temp = itr.next();
			if(checkPlayerCanCatchPlate(temp)){
				remove.add(temp);
				continue;
			}
			moveShapes(temp);
			if(checkPlayerCanCatchPlate(temp)){
				remove.add(temp);
				continue;
			}
			if(checkReturnToThePool(temp)) remove.add(temp);
		}
		for (int i = 0; i < remove.size(); i++) {
			fallingarea.remove(remove.get(i));
		}
	}
	
	public boolean checkReturnToThePool(Shape a)
	{
		if(a.getPostionY()-a.getHeightRadius()>=getGameModel().getScreenSize().height)
		{
			getGameModel().getShapesPool().addShape(a);
			return true;
		}
		return false;
	}
	
	public void moveShapes(Shape a)
	{
		a.setPostionX(a.getPostionX()+moves[0].x);
		a.setPostionY(a.getPostionY()+moves[0].y);	
	}
	
	public boolean checkPlayerCanCatchPlate(Shape a){
		if(getGameModel().getPlayer1().getRightHand().CanCatchIt(a))
		{
			System.out.println("test1");
			getGameModel().getPlayer1().getRightHand().addShape(a);
			return true;
		}
		if(getGameModel().getPlayer1().getLeftHand().CanCatchIt(a))
		{
			getGameModel().getPlayer1().getLeftHand().addShape(a);
			return true;
		}
		if(getGameModel().getPlayer2().getRightHand().CanCatchIt(a))
		{
			getGameModel().getPlayer2().getRightHand().addShape(a);
			return true;
		}
		if(getGameModel().getPlayer2().getLeftHand().CanCatchIt(a))
		{
			getGameModel().getPlayer2().getLeftHand().addShape(a);
			return true;
		}
		return false;
	}
	
	public void addShape(Shape a)
	{
		a.setShapeState(a.getFalling());
		fallingarea.add(a);
	}
	@Override
	public Iterator<Shape> createIterator() {
		return fallingarea.iterator();
	}
	
	public static class node
	{
		int x,y;
		public node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

	@Override
	public void drawShape(Graphics g) {
		Iterator<Shape> itr = createIterator();
		while(itr.hasNext())
		{
			itr.next().drawShape(g);
		}
	}
	
	
}
