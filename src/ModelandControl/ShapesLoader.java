package ModelandControl;

public class ShapesLoader {
	private static ShapesLoader shapesLoader;
	
	private ShapesLoader(){
		
	}
	public Class[] getValiableShapes(){
		
		if (shapesLoader ==null){
			shapesLoader = new ShapesLoader();
		}
		
		return null;
		
	}
}
