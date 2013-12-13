package ModelandControl;
import java.awt.Color;


public class Shape2 extends Shape{
	public Shape2(){
		System.out.println("shape2");
	}
	public Shape2(Color c, int x, int y, int widthradius, int hightradius) {
		super(c, x, y, widthradius, hightradius);
		System.out.println(c.toString()+x + y +widthradius+hightradius);

	}

}
