import java.io.Serializable;



public class ShapeNotVisual implements ShapeState,Serializable{
	
	Shape shape;
	public ShapeNotVisual(Shape a) {
		shape = a;
	}
	
	@Override
	public void nextAction() {
		// TODO Auto-generated method stub
		
	}

}
