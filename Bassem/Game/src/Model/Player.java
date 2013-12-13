package Model;

public class Player {
	PlayerHand righthand;
	PlayerHand lefthand;
	int posX;
	int posY;
	int id;
	int score;
	
	public Player(int x ,int y, int ID) {
		posX = x;
		posY = y;
		id = ID ;
		score = 0;
		righthand = new PlayerHand(this);
		lefthand = new PlayerHand(this);
	}
	
	public void setPosX(int x){ posX = x;}
	public void setPosY(int y){ posY = y;}
	public void setID(int ID) { id  = ID;}
	public void setScore(int score) {this.score = score;}
	
	
	public int getPosX(){ return  posX;}
	public int getPosY(int x){return posY;}
	public int getID(){ return id;}
	public int getRightHandSize() {return righthand.getHandSize();}
	public int getLefttHandSize() {return lefthand.getHandSize();}
	public int getScore() {return score;}
	
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
