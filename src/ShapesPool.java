
import java.io.Serializable;
import java.util.*;
public class ShapesPool implements Serializable{
	private Queue<Shape> pool;
	final int max_shapes_number = 100;
	public ShapesPool() {
		pool = new LinkedList<Shape>();
		generatePool();
	}
	
	public int getShapesLeftInThePool() {return pool.size();}
	
	private void generatePool()
	{
		ShapesFactory factory = new ShapesFactory();
		for (int i = 0; i < max_shapes_number; i++) {
			pool.add(factory.getShape());
		}
		
	}
	
	public Shape getShape()
	{
		if(pool.isEmpty()) return null; // all the shapes are taken and the pool is empty
		Shape shape = pool.poll();
		shape.setShapeState(shape.getOnTheLine()); // changing the state from not visual to on the line
		return shape; // get a shape from the pool
	}
	
	public void addShape(Shape a)
	{
		a.setShapeState(a.getNotVisual()); // changing the state from any thing to not visual [adding it to the pool]
		pool.add(a);
	}

	public void addNewShape(Class loadClass) {
		// TODO Auto-generated method stub
		ShapesFactory.addShapeType(loadClass);
	}
	
}
