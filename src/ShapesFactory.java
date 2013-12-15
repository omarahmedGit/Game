
import java.awt.Color;


public class ShapesFactory {
	private static Color[] color = {Color.BLACK,Color.RED,Color.green,Color.BLUE};
	public static Shape getShape(int x)
	{
		return new Shape(color[x], 20,20,20,20);
	}
	public static int getColorSize() {return color.length;}

}
