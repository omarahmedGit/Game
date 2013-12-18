

import java.awt.Dimension;
import java.util.ArrayList;

public interface ReadOnlyGameModel {
	
	public ArrayList<Drawable> getShapesArray();

	public boolean playerOneLose(); 
	public boolean playertwoLose(); 
	
	public Dimension getScreenDim();

	public int getPlayer1Score();
	public int getPlayer2Score();


}
