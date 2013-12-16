
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Shape3 extends Shape implements Drawable{
	public Shape3(){
	}
	public Shape3(Color c, int x, int y) {
		super(c, x, y);
		setWidthRedius(20);
		setHeightRedius(20);
	}
	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.fillRect(this.getPostionX()-getWidthRadius(),this.getPostionY()-getHeightRadius() ,this.getWidthRadius()*2 ,this.getHeightRadius()*2);	
	}
}
