import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class GameLoading {
	public GameLoading(){
		
	}
	public GameModel loadGame(){
		
		String fileName="data.bin";
		try {
			ObjectInputStream is=new ObjectInputStream(new FileInputStream(fileName));
			GameModel gameModel=(GameModel) is.readObject();
			is.close();
			return gameModel;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
