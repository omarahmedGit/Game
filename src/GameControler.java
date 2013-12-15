

import java.awt.Dimension;

public class GameControler implements Updator {
	UpdateGameModelInfc gameModel;
	public GameControler(UpdateGameModelInfc model, Dimension screenSize) {
		// TODO Auto-generated constructor stub
		gameModel=model;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
//		test
		gameModel.updateShapePos(1, 1);
		gameModel.update();
		
	}

	@Override
	public void updatePlayer1KeyBoard(int i) {
		// TODO Auto-generated method stub
		gameModel.updatePlayer1(i);
		
	}

	@Override
	public void updatePlayer2Mouse(int x) {
		// TODO Auto-generated method stub
		gameModel.updatePlayer2(x);
	}

}
