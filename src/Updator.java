

public interface Updator {
	public void update();

	public void updatePlayer1KeyBoard(int i);
	public void updatePlayer2Mouse(int x);

	public boolean checkWinningPlayer1();
	public boolean checkWinningPlayer2();

	public int getMaxScore();
	
}
