


import java.awt.Dimension;

public class GameBuilder {
	private static GameBuilder gameBuilder;
	private GameBuilder(){
	}
	public void startNewGame(Dimension screenSize){
		GameModel model=new GameModel(screenSize);
		GameControler controller =new GameControler((UpdateGameModelInfc) model,screenSize);
		ReadOnlyGameModel readModel=model;
		GameView view =new GameView(readModel ,(Updator) controller);
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
