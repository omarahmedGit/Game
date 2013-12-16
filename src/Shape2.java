
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Shape2 extends Shape implements Drawable{
	public Shape2(){
	}
	public Shape2(Color c, int x, int y) {
		super(c, x, y);
		setWidthRedius(40);
		setHeightRedius(40);
	}
	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.fillRect(this.getPostionX(),this.getPostionY() ,this.getWidthRadius() ,this.getHeightRadius());	
	}
}
