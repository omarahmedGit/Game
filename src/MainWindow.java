
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MainWindow extends JFrame {

	private JPanel contentPane;
	private GameBuilder builder;
	

	/**
	 * Create the frame.
	 * @param screenSize 
	 */
	public MainWindow(final Dimension screenSize) {
		builder =GameBuilder.makeGameBuilder();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
 
		JButton btnNewButton = new JButton("Start new Game");
		btnNewButton.setBounds(268, 159, 130, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				builder.startNewGame(screenSize);
			}
		});
		
		JButton btnNewButton_1 = new JButton("load saved game");
		btnNewButton_1.setBounds(268, 207, 130, 36);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLoading gl=new GameLoading();
				builder.startSavedGame(gl.loadGame(),screenSize);
			}
		});

		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setBounds(268, 300, 130, 37);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				this.
			}
		});
		
		JButton btnNewButton_2 = new JButton("Load new Shape");
		btnNewButton_2.setBounds(268, 254, 130, 35);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(null);
//				String className = fileChooser.getSelectedFile().getName();
//
//				className = className.substring(0, className.length() - 6);
//
//				String loc = fileChooser.getSelectedFile().getAbsolutePath();
//				loc = loc.substring(0, fileChooser.getSelectedFile()
//						.getAbsolutePath().length()
//						- 7 - className.length());
//				System.out.println(loc);
//				File file = new File(loc);
				 File source = new File(fileChooser.getSelectedFile().getPath());
				 File dest = new File("D:\\Game Folder\\Shapes\\" +fileChooser.getSelectedFile().getName());
				 try {
				 copyFile(source, dest);
				 } catch (IOException e1) {
				 // TODO Auto-generated catch block
				 e1.printStackTrace();
				 }
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_2);
	}
	private static void copyFile(File sourceFile, File destFile)
			throws IOException {
		if (!sourceFile.exists()) {
			return;
		}
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		source = new FileInputStream(sourceFile).getChannel();
		destination = new FileOutputStream(destFile).getChannel();
		if (destination != null && source != null) {
			destination.transferFrom(source, 0, source.size());
		}
		if (source != null) {
			source.close();
		}
		if (destination != null) {
			destination.close();
		}

	}
}
