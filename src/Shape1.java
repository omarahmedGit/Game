
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
		setWidthRedius(40);
		setHeightRedius(40);
	}
	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.fillOval(this.getPostionX(),this.getPostionY() ,this.getWidthRadius() ,this.getHeightRadius());
	}

}
