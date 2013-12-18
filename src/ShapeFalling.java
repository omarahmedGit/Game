import java.io.Serializable;



public class ShapeFalling implements ShapeState,Serializable{
	
	Shape shape;
	public ShapeFalling(Shape a) {
		shape = a;
	}
	
	@Override
	public void nextAction() {
		// TODO Auto-generated method stub
		
	}

}
