

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Belt implements ShapesIterator,Drawable{
	// belt is the line which the plates walks on and fall off it 
	int start, end, position;
	ArrayList<Shape> line;
	int direction ;
	int spaceBtweenPlates = 5;
	GameModel game;
	public Belt(int start, int end, GameModel game) {
		this.start = start;
		this.end   = end;
		line = new ArrayList<Shape>();
		if(start<end)
			direction = 2;
		else
			direction =-2;
		this.game = game;
	}
	
	public int getPlatesNumber() {return line.size();}
	
	public void addShapesToBelt()
	{
		if(game.pool.getShapesLeftInThePool()==0){
			// shouldn't get here ever !
			return ;
		}
		
		if(getPlatesNumber()>0)
		{
			Shape temp = line.get(getPlatesNumber()-1);
			if(start>end)
			{
				if(!(temp.getPostionX()+temp.getWidth()+spaceBtweenPlates<=start)){
					return ;
				}
			}
			else
			{
				if(!(temp.getPostionX()-temp.getWidth()>=start+spaceBtweenPlates)){
					return ;
				}
			}
		}
		
		Shape shape = game.pool.getShape();
		shape.setPostionX(start>end?start + shape.getWidth():start-shape.getWidth());
		shape.setPostionY(position-shape.getHeight());
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
				game.fall.addShape(temp);
				line.remove(temp);
			}
			else if(temp.getPostionX()<end&&direction<0)
			{
				game.fall.addShape(temp);
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
