


import java.awt.Dimension;

public class GameBuilder {
	private static GameBuilder gameBuilder;
	public GameBuilder(){
	}
	public void startNewGame(Dimension screenSize){
		GameModel model=new GameModel(screenSize);
		UpdateGameModelInfc u=model;
		GameControler controller =new GameControler((UpdateGameModelInfc) model,screenSize);
		ReadOnlyGameModel readModel=model;
		GameWindow view =new GameWindow(new GameView(readModel, controller));


	}
	public static GameBuilder makeGameBuilder(){
		if (gameBuilder==null){
			System.out.println("bassem");
			gameBuilder=new GameBuilder();
		}
		System.out.println("bosssaa");
		return gameBuilder;
	}
	public void startSavedGame(String s ,Dimension screenSize) {
		GameModel model=new GameModel("ssss" ,screenSize);
		GameControler controller =new GameControler((UpdateGameModelInfc) model ,screenSize);
		GameView view =new GameView((ReadOnlyGameModel) model ,(Updator) controller);

	}

}