import java.awt.Dimension;



public interface UpdateGameModelInfc {
	public void update();
	public void updatePlayer1(int x);
	public void updatePlayer2(int x);
	public int getplaye1Score();
	public int getplaye2Score();
	Dimension getScreenDim();
}
