

import java.awt.Dimension;

public class GameControler implements Updator {
	UpdateGameModelInfc gameModel;
	private int maxScore;
	public GameControler(UpdateGameModelInfc model, Dimension screenSize) {
		gameModel=model;
		maxScore=2;
	}

	@Override
	public void updatePlayer1KeyBoard(int i) {
		gameModel.updatePlayer1(i);
	}

	@Override
	public void updatePlayer2Mouse(int x) {
		gameModel.updatePlayer2(x);
	}

	@Override
	public void update() {
		gameModel.update();
	}



	@Override
	public boolean checkWinningPlayer1() {
		// TODO Auto-generated method stub
		if (gameModel.getplaye1Score() >=maxScore){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkWinningPlayer2() {
		// TODO Auto-generated method stub
		if (gameModel.getplaye2Score() >=maxScore){
			return true;
		}
		return false;
	}

	@Override
	public int getMaxScore() {
		// TODO Auto-generated method stub
		return maxScore;
	}

}
