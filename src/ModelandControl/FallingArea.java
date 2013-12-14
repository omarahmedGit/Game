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
	@Override
	public Iterator<Shape> createIterator() {
		return fallingarea.iterator();
	}
	
	
	
}
