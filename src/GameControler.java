

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
<<<<<<< HEAD
		gameModel.update();
=======
		// TODO Auto-generated method stub
		gameModel.update();
		
>>>>>>> c62b7c1c6b3e742832474aa8f99b9a2a14df0367
	}

}
