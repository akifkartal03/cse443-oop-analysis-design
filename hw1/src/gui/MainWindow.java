package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
		//setBounds(100,100,652, 380);
		setSize(601,707);
		setLocation(300,20);
		/*contentPanel = new MainJPanel();
		//contentPanel.setBounds(7, 7, 478, 452);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		addKeyListener(contentPanel);*/
		
		  JTextArea logArea = new JTextArea("Game Just Started!",8, 40);
		  logArea.setEditable(false);
		  logArea.setFocusable(false);
	      JScrollPane chatScroll = new JScrollPane(logArea);
	      JPanel chatPanel = new JPanel(new BorderLayout());
	      chatPanel.add(new JLabel("Log:", SwingConstants.LEFT), BorderLayout.PAGE_START);
	      chatPanel.add(chatScroll);
	      contentPanel = new MainJPanel(logArea);
	      //contentPanel.setBounds(0, 0, 478, 400);
	      //contentPanel.requestFocus();
	      //contentPanel.setFocusable(true);
	      
	      JPanel mainPanel = new JPanel();
	      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
	      mainPanel.add(contentPanel);
	      mainPanel.add(Box.createVerticalStrut(10));
	      mainPanel.add(chatPanel);
	      //setLocationRelativeTo(null);

	      //getContentPane().add(mainPanel);
	      setContentPane(mainPanel);
	      addKeyListener(contentPanel);
	      /*for(int i = 0; i < 100; i++) {
	    	  logArea.append("\nakif kartal"+ i);
	      }*/
	      
	      //pack();
	      //setLocationRelativeTo(null);
		
		
		
		
		/*JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(533, 79, 69, 68);*/
		
		/*JButton btnNewButton_1 = new JButton("New button");
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
		getContentPane().add(p1);*/
		
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
