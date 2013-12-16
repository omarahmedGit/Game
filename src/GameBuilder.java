


import java.awt.Dimension;

public class GameBuilder {
	private static GameBuilder gameBuilder;
	public static GameWindow view;
	private GameBuilder(){
		
	}
	public static void startNewGame(Dimension screenSize){
		GameModel model=new GameModel(screenSize);
		UpdateGameModelInfc u=model;
		GameControler controller =new GameControler((UpdateGameModelInfc) model,screenSize);
		ReadOnlyGameModel readModel=model;
		view =GameWindow.makeGameWindow(new GameView(readModel, controller));


	}
	public static GameBuilder makeGameBuilder(){
		if (gameBuilder==null){
			System.out.println("bassem");
			gameBuilder=new GameBuilder();
		}
		System.out.println("bosssaa");
		return gameBuilder;
	}
	public static void startSavedGame(GameModel gameModel ,Dimension screenSize) {
		GameModel model=new GameModel(gameModel ,screenSize);
		UpdateGameModelInfc u=model;
		GameControler controller =new GameControler((UpdateGameModelInfc) model,screenSize);
		ReadOnlyGameModel readModel=model;
		view =GameWindow.makeGameWindow(new GameView(readModel, controller));

	}

}
