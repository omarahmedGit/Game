import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MyMenu2 extends JFrame {

	private JPanel contentPane;
	private GameView gameView;
	boolean isVisible;
	/**
	 * Launch the application.
	 */
	public MyMenu2(GameView GV ) {
		gameView=GV;
		isVisible=true;
		this.setBackground(Color.RED);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
//		this.setVisible(true)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 400, 236, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Resume Game");
		btnNewButton.setBounds(15, 16, 206, 47);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gameView.resume();
			}
		});
		
//		JButton button = new JButton("Restart Game");
//		button.setBounds(15, 81, 206, 47);
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				GameWindow.closeGameWindow();
//				GameBuilder builder=GameBuilder.makeGameBuilder();
//				builder.startNewGame(gameView.getMaximumSize());
//			}
//		});
		
		JButton button_1 = new JButton("Save Game");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameSaving gs=new GameSaving();

//				System.out.println(dateFormat.format(cal.getTime()));
				gs.saveGame(gameView.getGameModel() );
			}
		});
		button_1.setBounds(15, 81, 206, 47);
		
//		JButton button_2 = new JButton("Load Shape");
//		button_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				gameView.loadShape(shapeLoader.loadClass());
//			}
//		});
//		button_2.setBounds(15, 211, 206, 47);
		
		JButton button_3 = new JButton("Exit Game");
		button_3.setBounds(15, 150, 206, 47);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GameWindow.closeGameWindow();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
//		contentPane.add(button);
		contentPane.add(button_1);
//		contentPane.add(button_2);
		contentPane.add(button_3);
	}
	
	public void setBounds(boolean f){
		if (f){
			setBounds(600, 400, 236, 240);
		}
		else {
			setBounds(600, 200, 236, 240);
		}
	}

}
