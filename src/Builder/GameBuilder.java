package Builder;


import ModelandControl.GameControler;
import ModelandControl.GameModel;
import ModelandControl.GameModelControlINF;
import ModelandControl.GameModelReadOnlyINF;
import View.GameView;

public class GameBuilder {
	private static GameBuilder gameBuilder;
	private GameBuilder(){
	}
	public void startNewGame(){
		GameModel model=new GameModel();
		GameView view =new GameView((GameModelReadOnlyINF) model);
		GameControler controller =new GameControler((GameModelControlINF) model);
	}
	public static GameBuilder makeGameBuilder(){
		if (gameBuilder==null){
			gameBuilder=new GameBuilder();
		}
		return gameBuilder;
	}
	public void startSavedGame(String s) {
		GameModel model=new GameModel("ssss");
		GameView view =new GameView((GameModelReadOnlyINF) model);
		GameControler controller =new GameControler((GameModelControlINF) model);
	}

}
