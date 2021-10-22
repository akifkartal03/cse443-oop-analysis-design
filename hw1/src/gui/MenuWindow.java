package gui;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuWindow extends JFrame {

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow frame = new MenuWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuWindow() {
		setTitle("Red Ball 443");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100,100,652, 380);
		setLocation(400,50);
		setSize(354,447);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow frame2 = new MainWindow();
				frame2.setVisible(true);
				frame2.createThread();
				frame2.startThread();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(111, 158, 98, 40);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome to GTU Red Ball 443 Game");
		lblNewLabel.setBounds(62, 65, 227, 51);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Options");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "D: Move Right\n"
						+ "Esc: Pause\nSpace: Jump", "Keyboard Options", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(111, 225, 98, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(111, 290, 98, 40);
		getContentPane().add(btnNewButton_2);
		
		
		
		
	}*/
}
