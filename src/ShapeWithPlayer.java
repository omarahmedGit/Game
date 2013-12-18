import java.io.Serializable;



public class ShapeWithPlayer implements ShapeState,Serializable{
	Shape shape;
	public ShapeWithPlayer(Shape a) {
		shape = a;
	}
	@Override
	public void nextAction() {
		// TODO Auto-generated method stub
		
	}

}
