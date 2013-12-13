import java.awt.Color;


public class Shape {
	Color c = Color.BLACK;
	int posX;
	int posY;
	int state;
	/* 
	 * every shape has [as i think] 7 states
	 * 1- in the pool and not visual on the screen
	 * 2- on the line belt
	 * 3- falling in free motion
	 * 4- a player hold it 
	 * 		a) with player1 right hand
	 * 		b) with player1 left  hand
	 * 		c) with player2 right hand
	 * 		d) with player2 left  hand
	 */
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
