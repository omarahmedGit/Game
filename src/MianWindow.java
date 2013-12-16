
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MianWindow extends JFrame {

	private JPanel contentPane;
	private GameBuilder builder;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					MianWindow frame = new MianWindow(screenSize);
					frame.setSize(screenSize);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @param screenSize 
	 */
	public MianWindow(final Dimension screenSize) {
		builder =new GameBuilder();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Start new Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				builder.startNewGame(screenSize);
			}
		});
		
		btnNewButton.setBounds(screenSize.width/2-130/2,screenSize.height/4-36/2, 130, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("load saved game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLoading gl=new GameLoading();
				builder.startSavedGame(gl.loadGame(),screenSize);
			}
		});
		btnNewButton_1.setBounds(screenSize.width/2-130/2,screenSize.height/4-36/2+50, 130, 36);
		contentPane.add(btnNewButton_1);

		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(screenSize.width/2-130/2,screenSize.height/4-36/2+100, 130, 36);
		contentPane.add(btnNewButton_3);
	}
}
