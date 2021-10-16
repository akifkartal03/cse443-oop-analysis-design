package akif;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Canvas;

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
		setBounds(100, 100, 450, 300);
		contentPanel = new MainJPanel();
		contentPanel.setBackground(Color.RED);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		addKeyListener(contentPanel);
		
		
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
