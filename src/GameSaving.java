import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class GameSaving {
	
	public GameSaving(){
		
	}
	public void saveGame(GameModel gameModel){
		DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm ss");
		Calendar cal = Calendar.getInstance();
		String fn=dateFormat.format(cal.getTime());
		String fileName="D:/Game Folder/Saved Games/"+fn+".bin";
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(gameModel);
			os.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
