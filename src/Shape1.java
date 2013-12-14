
import java.awt.Color;
import java.awt.Graphics;


public class Shape1 extends Shape{
	public Shape1(){
		System.out.println("shape1");
	}
	public Shape1(Color c, int x, int y, int widthradius, int hightradius) {
		super(c, x, y, widthradius, hightradius);
		System.out.println(c.toString()+x + y +widthradius+hightradius);
	}
	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
