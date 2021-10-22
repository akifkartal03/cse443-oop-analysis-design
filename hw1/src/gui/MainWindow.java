package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainWindow extends JFrame {

	private MainJPanel contentPanel;
	private Thread gameThread;
	private JTextArea logArea;
	private JScrollPane chatScroll;
	private JPanel chatPanel;
	private JPanel mainPanel;

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
					JOptionPane.showMessageDialog(null, "Welcome to GTU Red Ball 443 Game"
							+ "\nPlease Start Game from Menu!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
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
		setLocation(400,20);
		
		JMenu menu,opt;  
        JMenuItem i1, i2, i3,i4;
        JMenuBar mb=new JMenuBar();  
        menu=new JMenu("Menu"); 
        i1=new JMenuItem("Start");
        i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contentPanel.getState() == GameState.Paused) {
					contentPanel.setState(GameState.Playing);
					logArea.append("\nGame Started. Use your keyboard!");
				}
				else if(contentPanel.getState() == GameState.Finished) {
					contentPanel.initGame();
					logArea.setText("Game Started. Use your keyboard!");
					contentPanel.setState(GameState.Playing);
				}
				
				//JOptionPane.showMessageDialog(null, "Game Started!\nGood Luck:)", "Game Started", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        i2=new JMenuItem("Pause");
        i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contentPanel.getState() == GameState.Playing) {
					contentPanel.setState(GameState.Paused);
					logArea.append("\nGame Paused!");
				}
				else if(contentPanel.getState() == GameState.Finished) {
					logArea.append("\nGame Over! Start Again.");
				}
				
				//JOptionPane.showMessageDialog(null, "Game Started!\nGood Luck:)", "Game Started", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        i3=new JMenuItem("Exit");
        i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        opt=new JMenu("Options"); 
        i4=new JMenuItem("Keyboard Options");
        i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "D: Move Right\n"
						+ "Space: Jump", "Keyboard Options", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        menu.add(i1); menu.add(i2); menu.add(i3); 
        opt.add(i4);
        mb.add(menu); 
        mb.add(opt); 
        setJMenuBar(mb);
        initGame();
        //initGame();
		/*contentPanel = new MainJPanel();
		//contentPanel.setBounds(7, 7, 478, 452);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		addKeyListener(contentPanel);*/
		
		 
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
	public void initGame() {
		logArea = new JTextArea("Game Paused!",8, 40);
		logArea.setEditable(false);
		logArea.setFocusable(false);
	    chatScroll = new JScrollPane(logArea);
	    chatPanel = new JPanel(new BorderLayout());
	    chatPanel.add(new JLabel("Log:", SwingConstants.LEFT), BorderLayout.PAGE_START);
	    chatPanel.add(chatScroll);
	    contentPanel = new MainJPanel(logArea);
	      //contentPanel.setBounds(0, 0, 478, 400);
	      //contentPanel.requestFocus();
	      //contentPanel.setFocusable(true);
	      
	      
	    mainPanel = new JPanel();
	    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
	    mainPanel.add(contentPanel);
	    mainPanel.add(Box.createVerticalStrut(10));
	    mainPanel.add(chatPanel);
	      //setLocationRelativeTo(null);
	
	      //getContentPane().add(mainPanel);
	    setContentPane(mainPanel);
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
