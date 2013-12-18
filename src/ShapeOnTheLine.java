import java.io.Serializable;



public class ShapeOnTheLine implements ShapeState,Serializable{
	
	Shape shape;
	public ShapeOnTheLine(Shape a) {
		shape = a;
	}
	
	
	@Override
	public void nextAction() {
		// TODO Auto-generated method stub
		
	}

}
