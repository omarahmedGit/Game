
import java.awt.Color;
import java.util.Stack;


public class PlayerHand {
	private Stack<Shape> hand;
	private Player player;
	private int handHeight;
	private int xPos,xPosEnd;
	private int tolerance = 5;
	public PlayerHand(Player p, int xPos) {
		hand = new Stack<Shape>();
		player = p;
		this.xPos = xPos;
		xPosEnd = xPos + player.getWidht()/3;
		handHeight = player.getPosY();
	}
	
	public int getHandSize() {return hand.size();}
	
	public int getHandHeight() {return handHeight;}
	
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
		a.setPostionX((xPos+xPosEnd)/2);
		a.setPostionY(handHeight-a.getHeightRadius());
		handHeight -= (2*a.heightRadius);
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
			handHeight += (hand.peek().heightRadius*2);
			player.gameModel.pool.addShape(hand.pop());
		}
	}
}
