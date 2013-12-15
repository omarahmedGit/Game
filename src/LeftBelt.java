import java.util.ArrayList;
import java.util.Iterator;


public class LeftBelt extends Belt{

	public LeftBelt(int start, int end, GameModel game) {
		super(start, end, game);
	}
	
	public void addShapesToBelt()
	{
		if(getGameModel().getShapesPool().getShapesLeftInThePool()==0){
			// shouldn't get here ever !
			return ;
		}
		
		if(getPlatesNumber()>0)
		{
			Shape temp = line.get(getPlatesNumber()-1);
			
				if(!(temp.getPostionX()-temp.getWidthRadius()>=getStart()+getSpaceBetweenPlates())){
					return ;
				}
		}
		
		Shape shape = getGameModel().getShapesPool().getShape();getClass();
		shape.setShapeState(shape.getOnTheLine());
		shape.setPostionX(getStart()-shape.getWidthRadius());
		shape.setPostionY(getPosition()-shape.getHeightRadius());
		line.add(shape);
	}
	
	public void moveShapes()
	{
		getCurrentState().change();
		ArrayList<Shape> remove = new ArrayList<Shape>();
 		Iterator<Shape> itr = createIterator();
		while(itr.hasNext())
		{
			Shape temp = itr.next();
						
			temp.setPostionX(temp.getPostionX()+getDirection());
			
			if(temp.getPostionX()>getEnd())
			{
				getGameModel().getFallingArea().addShape(temp);
				remove.add(temp);
			}
		}
		for (int i = 0; i < remove.size(); i++) {
			line.remove(remove.get(i));
		}
		
	}
	
	public boolean checkstdAndcurrentEndTaller()
	{
		if(getEnd()>getStdEnd()) return true;
		return false;
	}
	
	public boolean checkstdAndcurrentEndSmaller()
	{
		if(getEnd()<getStdMinEnd()) return true;
		return false;
	}

}
