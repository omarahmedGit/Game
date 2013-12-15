
import java.awt.Color;
import java.util.Iterator;
import java.util.Stack;


public class PlayerHand implements ShapesIterator{
	private Stack<Shape> hand;
	private Player player;
	private int handHeight;
	private int xPos,xPosEnd;
	private int tolerance = 5;
	public PlayerHand(Player p, int xPos) {
		hand = new Stack<Shape>();
		setPlayer(p);
		setXPos(xPos);
		setXPosEnd(xPos + player.getWidht()/3);
		setHandHeight(player.getPosY());
	}
	
	public int getHandSize() {return hand.size();}
	public int getHandHeight() {return handHeight;}
	public int getXPos() {return xPos;}
	public int getXPosEnd() {return xPosEnd;}
	public int getTolerance() {return tolerance;}
	public Player getPlayer() {return player;}
	
	public void setHandHeight(int height) {handHeight = height;}
	public void setXPos(int x) {xPos = x;}
	public void setXPosEnd(int xEnd) {xPosEnd = xEnd;}
	public void setTolerance(int tolerance) {this.tolerance = tolerance;}
	public void setPlayer(Player player) {this.player = player;}
	
	
	
	public boolean CanCatchIt(Shape a)
	{
		int shape_lower_bound = a.getPostionY() + a.getHeightRadius();
		if(Math.abs(shape_lower_bound-getHandHeight())<tolerance)
		{
			int leftCorner = a.getPostionX()-a.getWidthRadius();
			int rightCorner= a.getPostionX()+a.getWidthRadius();
			if(rightCorner<=xPosEnd&rightCorner>=xPos) return true;
			if(leftCorner>=xPos&&rightCorner<=xPosEnd) return true;
			if(rightCorner>=xPosEnd&&leftCorner<=xPos) return true;
			if(rightCorner<=xPosEnd&&leftCorner>=xPos) return true;
		}
		return false;
	}
	
	public void addShape(Shape a)
	{
		a.setShapeState(a.getWithPlayer());
		a.setPostionX((getXPos()+getXPosEnd())/2);
		a.setPostionY(getHandHeight()-a.getHeightRadius());
		setHandHeight(getHandHeight() - (2*a.getHeightRadius()));
		hand.add(a);
	}
	
	
	public void checkIfThreePlatesOfTheSameColor()
	{
		if(getHandSize()<3) return ;
		Stack<Shape> temp = new Stack<Shape>();
		Color testEquality = temp.peek().getColor() ;
		Boolean checkPlates = true;
		for (int i = 0; i < 3; i++) {
			temp.add(hand.pop());
			if(!testEquality.equals(temp.peek().getColor())) checkPlates = false ;
		}
		while(!temp.isEmpty())
		{
			hand.add(temp.pop());
		}
		
		if(checkPlates) {
			removeTopThreeShapes();
			getPlayer().incrementPlayerScore();
		}
		
	}
	public void removeTopThreeShapes()
	{
		if(getHandSize()<3) return ; //should never happen 
		for (int i = 0; i < 3; i++) {
			setHandHeight(getHandHeight()+(hand.peek().getHeightRadius()*2));
			getPlayer().getGameModel().getShapesPool().addShape(hand.pop());
		}
	}

	@Override
	public Iterator<Shape> createIterator() {
		return hand.iterator();
	}
}
