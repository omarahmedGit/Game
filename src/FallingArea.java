
import java.util.ArrayList;
import java.util.Iterator;



public class FallingArea implements ShapesIterator{
	ArrayList<Shape> fallingarea;
	GameModel game;
	private node[] moves = new node[3];
	public FallingArea(GameModel game) {
		fallingarea = new ArrayList<Shape>();
		setGameModel(game);
		moves[0] = new node(0 ,1);
		moves[1] = new node(-1,1);
		moves[2] = new node(1 ,1);
		
	}
	
	public GameModel getGameModel() {return game;}
	public ArrayList<Shape> getShapesList() {return fallingarea;}
	
	public void setGameModel(GameModel game) {this.game=game;}
	
	public void getIntoAction() {
		Iterator<Shape> itr = createIterator();
		
		while(itr.hasNext())
		{
			Shape temp = itr.next();
			if(checkPlayerCanCatchPlate(temp)) continue;
			moveShapes(temp);
			if(checkPlayerCanCatchPlate(temp)) continue;
			checkReturnToThePool(temp);
		}
	}
	
	public void checkReturnToThePool(Shape a)
	{
		if(a.getPostionY()-a.getHeightRadius()>=getGameModel().getScreenSize().height)
		{
			getGameModel().getShapesPool().addShape(a);
			fallingarea.remove(a);
		}
	}
	
	public void moveShapes(Shape a)
	{
		int random = (int)(Math.random()*2);
		a.setPostionX(a.getPostionX()+moves[random].x);
		a.setPostionY(a.getPostionY()+moves[random].y);	
	}
	
	public boolean checkPlayerCanCatchPlate(Shape a){
		if(getGameModel().getPlayer1().getRightHand().CanCatchIt(a))
		{
			getGameModel().getPlayer1().getRightHand().addShape(a);
			fallingarea.remove(a);
			return true;
		}
		else if(getGameModel().getPlayer1().getLeftHand().CanCatchIt(a))
		{
			getGameModel().getPlayer1().getLeftHand().addShape(a);
			fallingarea.remove(a);
			return true;
		}
		else if(getGameModel().getPlayer2().getRightHand().CanCatchIt(a))
		{
			getGameModel().getPlayer2().getRightHand().addShape(a);
			fallingarea.remove(a);
			return true;
		}
		else if(getGameModel().getPlayer2().getRightHand().CanCatchIt(a))
		{
			getGameModel().getPlayer2().getLeftHand().addShape(a);
			fallingarea.remove(a);
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
	
	
}
