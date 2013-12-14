
import java.awt.Color;
import java.util.Stack;


public class PlayerHand {
	private Stack<Shape> hand;
	private Player player;
	private int handHeight = 0;
	public PlayerHand(Player p) {
		hand = new Stack<Shape>();
		player = p;
	}
	
	public int getHandSize() {return hand.size();}
	
	public int getHandHeight() {return handHeight;}
	
	public boolean CanCatchIt(Shape a)
	{
		// need to impelent it
		
		return true;
	}
	
	public void addShape(Shape a)
	{
		a.setShapeState(a.getWithPlayer());
		handHeight += (2*a.heightRadius);
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
			player.incrementPlayerScore();
		}
		
	}
	public void removeTopThreeShapes()
	{
		if(getHandSize()<3) return ; //should never happen 
		for (int i = 0; i < 3; i++) {
			handHeight -= (hand.peek().heightRadius*2);
			player.gameModel.pool.addShape(hand.pop());
		}
	}
}
