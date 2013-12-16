
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Shape1 extends Shape implements Drawable{
	Rectangle r;
	public Shape1(){
		System.out.println("shape1");
	}
	public Shape1(Color c, int x, int y) {
		super(c, x, y);
	}
	@Override
	public void drawShape(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(this.getPostionX(),this.getPostionY() ,this.getWidthRadius() ,this.getHeightRadius());
	}

}
