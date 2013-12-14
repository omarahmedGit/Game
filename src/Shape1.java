
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Shape1 extends Shape{
	Rectangle r;
	public Shape1(){
		System.out.println("shape1");
	}
	public Shape1(Color c, int x, int y, int widthradius, int hightradius) {
		super(c, x, y, widthradius, hightradius);

		
		System.out.println(c.toString()+x + y +widthradius+hightradius);
//		Rectangle r= new Rectangle(x, y, widthradius, getHeightRadius());
	}
	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
//		test
		g.setColor(Color.black);
		g.drawRect(this.getPostionX(),this.getPostionY() ,this.getWidthRadius() ,this.getHeightRadius());
		
	}

}
