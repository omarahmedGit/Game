
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Shape2 extends Shape{
	public Shape2(){
		System.out.println("shape2");
	}
	public Shape2(Color c, int x, int y, int widthradius, int hightradius) {
		super(c, x, y, widthradius, hightradius);
		System.out.println(c.toString()+x + y +widthradius+hightradius);

	}
	@Override
	public void drawShape(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(this.getPostionX(),this.getPostionY() ,this.getWidthRadius() ,this.getHeightRadius());
		
	}
}
