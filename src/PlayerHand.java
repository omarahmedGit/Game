
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.Stack;


public class PlayerHand implements Drawable,ShapesIterator{
	private Stack<Shape> hand;
	private Player player;
	private int handHeight;
	private int xPos,xPosEnd;
	private int tolerance = 5;
	public PlayerHand(Player p, int xPos) {
		hand = new Stack<Shape>();
		setPlayer(p);
		setXPos(xPos);
		setHandHeight(getPlayer().getPosY());
	}
	
	public int getHandSize() {return hand.size();}
	public int getHandHeight() {return handHeight;}
	public int getXPos() {return xPos;}
	public int getXPosEnd() {return xPosEnd;}
	public int getTolerance() {return tolerance;}
	public Player getPlayer() {return player;}
	
	public void setHandHeight(int height) {handHeight = height;}
	public void setXPosEnd(int xEnd) {xPosEnd = xEnd;}
	public void setTolerance(int tolerance) {this.tolerance = tolerance;}
	public void setPlayer(Player player) {this.player = player;}
	public void setXPos(int x) {
		System.out.println(x);
		if(x<0){
			System.out.println("sajkhdksjahdjksajdklsajdl");
		}
		xPos = x;
		xPosEnd = x + getPlayer().getWidht()/3;
	}
	
	
	public boolean CanCatchIt(Shape a)
	{
		int shape_lower_bound = a.getPostionY() + a.getHeightRadius();
		if(Math.abs(shape_lower_bound-getHandHeight())<tolerance)
		{
			int leftCorner = a.getPostionX()-a.getWidthRadius();
			int rightCorner= a.getPostionX()+a.getWidthRadius();
			System.out.println(getXPos() +" "+leftCorner);
			if(rightCorner<=getXPosEnd()&rightCorner>=getXPos()) return true;
			if(leftCorner>=getXPos()&&rightCorner<=getXPosEnd()) return true;
			if(rightCorner>=getXPosEnd()&&leftCorner<=getXPos()) return true;
			if(rightCorner<=getXPosEnd()&&leftCorner>=getXPos()) return true;
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
		checkIfThreePlatesOfTheSameColor();
	}
	
	
	public void checkIfThreePlatesOfTheSameColor()
	{
		if(getHandSize()<3) return ;	
		Stack<Shape> temp = new Stack<Shape>();
		Color testEquality = hand.peek().getColor() ;
		Boolean checkPlates = true;
		for (int i = 0; i < 3; i++) {
			if(!(testEquality.getRGB()==hand.peek().getColor().getRGB())) {
				checkPlates = false ;
			}
			temp.add(hand.pop());
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

	@Override
	public void drawShape(Graphics g) {
		Iterator<Shape> itr = createIterator();
		while(itr.hasNext())
		{
			itr.next().drawShape(g);
		}		
	}
}
