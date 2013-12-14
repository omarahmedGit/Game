package Builder;


import java.awt.Dimension;

import ModelandControl.GameControler;
import ModelandControl.GameModel;
import ModelandControl.UpdateGameModelInfc;
import ModelandControl.ReadOnlyGameModel;
import ModelandControl.Updator;
import View.GameView;

public class GameBuilder {
	private static GameBuilder gameBuilder;
	private GameBuilder(){
	}
	public void startNewGame(Dimension screenSize){
		GameModel model=new GameModel(screenSize);
		GameControler controller =new GameControler((UpdateGameModelInfc) model,screenSize);
		GameView view =new GameView((ReadOnlyGameModel) model ,(Updator) controller);
	}
	public static GameBuilder makeGameBuilder(){
		if (gameBuilder==null){
			gameBuilder=new GameBuilder();
		}
		return gameBuilder;
	}
	public void startSavedGame(String s ,Dimension screenSize) {
		GameModel model=new GameModel("ssss" ,screenSize);
		GameControler controller =new GameControler((UpdateGameModelInfc) model ,screenSize);
		GameView view =new GameView((ReadOnlyGameModel) model ,(Updator) controller);

	}

}
