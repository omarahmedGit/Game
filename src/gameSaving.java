import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class gameSaving {
	
	public gameSaving(){
		
	}
	public void saveGame(GameModel gameModel){
		String fileName="data.bin";
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
