
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Shape1 extends Shape implements Drawable{
	Rectangle r;
	static int w=35;
	static int l=35;
	public Shape1(){
		System.out.println("shape1");
	}
	public Shape1(Color c, int x, int y) {
		super(c, x, y);
		setWidthRedius(w);
		setHeightRedius(l);
	}
	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.fillOval(this.getPostionX()-getWidthRadius(),this.getPostionY()-getHeightRadius() ,this.getWidthRadius()*2 ,this.getHeightRadius()*2);
	}

}
