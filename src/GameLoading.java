import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;


public class GameLoading {
	public GameLoading(){
		
	}
	public GameModel loadGame(){
        File directory = new File("Game Folder\\Saved Games");
        JFileChooser fileChooser = new JFileChooser(directory);
        fileChooser.showOpenDialog(null);
		String fileName=fileChooser.getSelectedFile().getAbsolutePath();
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
