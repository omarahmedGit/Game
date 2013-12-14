
public class Player {
	PlayerHand righthand;
	PlayerHand lefthand;
	private int posX; // top left X
	private int posY; // top left Y
	private int id;
	private int score;
	private int height, width;
	String name;
	GameModel gameModel;
	
	public Player(int ID, GameModel gameModel) {
		id = ID ;
		score = 0;
		this.gameModel = gameModel;
		setDimension();
		righthand = new PlayerHand(this, (getPosX() + getPosX()/3));
		lefthand = new PlayerHand(this, getPosX());
	}
	
	public void setPosX(int x){ posX = x;}
	public void setPosY(int y){ posY = y;}
	public void setID(int ID) { id  = ID;}
	public void setScore(int score) {this.score = score;}
	public void setName(String name) {this.name = name;}
	public void setHeight(int height) {this.height = height;}
	public void setWidth(int width) {this.width = width;}
	
	public int getPosX(){ return  posX;}
	public int getPosY(){return posY;}
	public int getID(){ return id;}
	public int getRightHandSize() {return righthand.getHandSize();}
	public int getLefttHandSize() {return lefthand.getHandSize();}
	public int getScore() {return score;}
	public String getName() {return name;}
	public PlayerHand getRightHand() {return righthand;}
	public PlayerHand getLeftHand() {return lefthand;}
	public int getHeight() {return height;}
	public int getWidht()  {return 	width;}
	
	private void setDimension()
	{
		setWidth(gameModel.getScreenSize().width/8);
		setHeight(gameModel.getScreenSize().height/4);
		if(id==1)
		{
			setPosY(gameModel.getScreenSize().height-(gameModel.getScreenSize().height/4));
			setPosX((gameModel.getScreenSize().width/2)+(gameModel.getScreenSize().width/2 - getWidht())/2);
		}
		else
		{
			setPosY(gameModel.getScreenSize().height-(gameModel.getScreenSize().height/4));
			setPosX((gameModel.getScreenSize().width/2 - getWidht())/2);			
		}
	}
	
	public void addShapeToRightHand(Shape a)
	{
		righthand.addShape(a);
	}
	
	public void addShapeToLeftHand(Shape a)
	{
		lefthand.addShape(a);
	}
	
	public void checkToRemovePlatesWithSameColor()
	{
		righthand.checkIfThreePlatesOfTheSameColor();
		lefthand.checkIfThreePlatesOfTheSameColor();
	}
	
	public void incrementPlayerScore() {setScore(getScore()+1);}
	
}
