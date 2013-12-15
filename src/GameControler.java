

import java.awt.Dimension;

public class GameControler implements Updator {
	UpdateGameModelInfc gameModel;
	public GameControler(UpdateGameModelInfc model, Dimension screenSize) {
		gameModel=model;
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

}
