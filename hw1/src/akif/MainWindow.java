package akif;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainWindow extends JFrame {

	private MainJPanel contentPanel;
	private Thread gameThread;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					frame.createThread();
					frame.startThread();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("HW1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,646, 505);
		setLocation(300,100);
		contentPanel = new MainJPanel();
		contentPanel.setBounds(7, 7, 478, 452);
		addKeyListener(contentPanel);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(533, 79, 69, 68);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(544, 242, 58, 63);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(533, 178, 69, 53);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		JPanel p1 = new JPanel();
		p1.setBounds(495, 7, 125, 326);
		p1.add(btnNewButton_2);
		p1.add(btnNewButton_1);
		p1.add(btnNewButton);
		getContentPane().add(p1);
		
		/*JButton but = new JButton("Button1");
		but.setBounds(555, 20, 50, 50);
		add(but);*/
		
		
	}
	public void createThread() {
		try {
			//contentPanel object is runnable and 
			//extends from JPanel class.
			gameThread = new Thread(contentPanel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void startThread() {
		gameThread.start();
	}
}
