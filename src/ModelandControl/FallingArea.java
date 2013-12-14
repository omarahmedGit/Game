package ModelandControl;
import java.util.ArrayList;
import java.util.Iterator;



public class FallingArea implements ShapesIterator{
	ArrayList<Shape> fallingarea;
	
	public FallingArea() {
		fallingarea = new ArrayList<Shape>();
	}
	public void moveShapes()
	{
		
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
	
	
	
}
