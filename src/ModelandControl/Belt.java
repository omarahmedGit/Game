package ModelandControl;

import java.util.ArrayList;

public class Belt {
	// belt is the line which the plates walks on and fall off it 
	int start, end;
	ArrayList<Shape> line;
	public Belt(int start, int end) {
		this.start = start;
		this.end   = end;
		line = new ArrayList<Shape>();
	}
	
	public int getPlatesNumber() {return line.size();}
	
	public void addShapesToBelt()
	{
		
	}
	
	public void moveShapes()
	{
		
	}
	
}
