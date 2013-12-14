

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Belt implements ShapesIterator,Drawable{
	private int start, end, position;
	ArrayList<Shape> line;
	private int direction = 2;
	private int spaceBtweenPlates = 5;
	private GameModel game;
	public Belt(int start, int end, GameModel game) {
		setStart(start);
		setEnd(end);
		setGameModel(game);
		position = game.getScreenSize().height/8;
		line = new ArrayList<Shape>();
		if(start>end)
			direction = -1*direction;
	}
	
	public void setStart(int start) {this.start = start;}
	public void setEnd(int end) {this.end = end;}
	public void setGameModel(GameModel game){this.game = game;}
	
	public int getStart() {return start;}
	public int getEnd() {return end;}
	public GameModel getGameModel(){return game;}
	
	public int getPlatesNumber() {return line.size();}
	
	public void addShapesToBelt()
	{
		if(getGameModel().getShapesPool().getShapesLeftInThePool()==0){
			// shouldn't get here ever !
			return ;
		}
		
		if(getPlatesNumber()>0)
		{
			Shape temp = line.get(getPlatesNumber()-1);
			if(start>end)
			{
				if(!(temp.getPostionX()+temp.getWidthRadius()+spaceBtweenPlates<=start)){
					return ;
				}
			}
			else
			{
				if(!(temp.getPostionX()-temp.getWidthRadius()>=start+spaceBtweenPlates)){
					return ;
				}
			}
		}
		
		Shape shape = getGameModel().getShapesPool().getShape();
		shape.setPostionX(start>end?start + shape.getWidthRadius():start-shape.getWidthRadius());
		shape.setPostionY(position-shape.getHeightRadius());
		line.add(shape);
	}
	
	public void moveShapes()
	{
		Iterator<Shape> itr = createIterator();
		while(itr.hasNext())
		{
			Shape temp = itr.next();
			
			// move + check if falls
			
			temp.setPostionX(temp.getPostionX()+direction);
			
			if(temp.getPostionX()>end&&direction>0)
			{
				getGameModel().getFallingArea().addShape(temp);
				line.remove(temp);
			}
			else if(temp.getPostionX()<end&&direction<0)
			{
				getGameModel().getFallingArea().addShape(temp);
				line.remove(temp);
			}
		}
		
	}

	@Override
	public Iterator<Shape> createIterator() {
		return line.iterator();
	}

	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		
		
	}
	
}
