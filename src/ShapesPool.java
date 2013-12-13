import java.util.*;
public class ShapesPool {
	Queue<Shape> pool;
	final int max_shapes_number = 100;
	public ShapesPool() {
		pool = new LinkedList<Shape>();
		generatePool();
	}
	
	public int getShapesLeftInThePool() {return pool.size();}
	
	private void generatePool()
	{
		int max = ShapesFactory.getColorSize() - 1;
		
		for (int i = 0; i < max_shapes_number; i++) {
			int random = (int) (Math.random() * max); // [0,color.length-1]
			pool.add(ShapesFactory.getShape(random));
		}
		
	}
	
	public Shape getShape()
	{
		if(pool.isEmpty()) return null; // all the shapes are taken and the pool is empty
		return pool.poll(); // get a shape from
	}
	
	public void addShape(Shape a)
	{
		pool.add(a);
	}
	
}
