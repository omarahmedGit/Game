import java.awt.Color;


public class Shape {
	Color c = Color.BLACK;
	int posX;
	int posY;
	
	public Shape(Color c,int x,int y) {
		this.c = c;
		posX = x;
		posY = y;
	}
	
	
	public int getPostionX() { return posX;}
	public int getPostionY() { return posY;}
	public Color getColor()  { return 	 c;}
	
	public void setPostionX(int x) { posX = x;}
	public void setPostionY(int y) { posY = y;}
	public void setColor(Color color)  { c = color ;}
	
}
