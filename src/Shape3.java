
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Shape3 extends Shape{
	public Shape3(){
	}
	public Shape3(Color c, int x, int y, int widthradius, int hightradius) {
		super(c, x, y);
	}
	@Override
	public void drawShape(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(this.getPostionX(),this.getPostionY() ,this.getWidthRadius() ,this.getHeightRadius());	
	}
}
