

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Belt implements ShapesIterator,Drawable{
	private int start, end, position;
	ArrayList<Shape> line;
	private int direction = 2;
	private int spaceBetweenPlates = 150;
	private GameModel game;
	private int stdEnd,stdMinEnd;
	private BeltState gettingTaller  = new GettingTaller(this);
	private BeltState gettingSmaller = new GettingSmaller(this);
	private BeltState currentState ;
	public Belt(int start, int end, GameModel game) {
		line = new ArrayList<Shape>();
		setStart(start);
		setEnd(end);
		setStandardMinEnd((end+start)/2);
		setStandardEnd(end);
		setGameModel(game);
		setCurrentBeltState(gettingSmaller);
		setPosition(game.getScreenSize().height/8);
	}
	
	public void setStart(int start) {this.start = start;}
	public void setEnd(int end) {this.end = end;}
	public void setGameModel(GameModel game){this.game = game;}
	public void setDirection(int direction) {this.direction = direction;}
	public void setPosition(int position) {this.position = position;}
	public void setSpaceBetweenPlates(int space) {this.spaceBetweenPlates= space;}
	public void setStandardMinEnd(int std) {stdMinEnd = std;}
	public void setStandardEnd(int std) {stdEnd = std;}
	public void setCurrentBeltState(BeltState state) {currentState = state;}
	
	public int getStart() {return start;}
	public int getEnd() {return end;}
	public GameModel getGameModel(){return game;}
	public int getDirection() {return direction;}
	public int getPlatesNumber() {return line.size();}
	public int getPosition() {return position;}
	public int getSpaceBetweenPlates() {return spaceBetweenPlates;}
	public int getStdMinEnd() {return stdMinEnd;}
	public int getStdEnd() {return stdEnd;}
	public BeltState getTaller() {return gettingTaller;}
	public BeltState getSmaller() {return gettingSmaller;}
	public BeltState getCurrentState() {return currentState;}
	
	public void addShapesToBelt() {}
	public void moveShapes() {}
	public boolean checkstdAndcurrentEndTaller() {return false;}
	public boolean checkstdAndcurrentEndSmaller() {return false;}
	
	public void makeItTaller() { setEnd(getEnd()+getDirection()); }
	public void makeItSmaller(){ setEnd(getEnd()-getDirection()); }
	
	@Override
	public Iterator<Shape> createIterator() {
		return line.iterator();
	}

	@Override
	public void drawShape(Graphics g) {		
		g.drawLine(getStart(), getPosition(), getEnd(), getPosition());
		Iterator<Shape> itr = createIterator();
		while(itr.hasNext())
		{
			itr.next().drawShape(g);
		}
	}
	
}
