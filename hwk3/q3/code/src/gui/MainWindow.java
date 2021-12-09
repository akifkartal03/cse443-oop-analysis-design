package gui;

import helper.SingleThread;
import javaSynchronized.SyncTestDrive;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

    private Thread panelThread;
    private MainJPanel contentPane1;
    private JPanel contentPane2;
    private JTextArea logArea;
    private JScrollPane chatScroll;
    private JPanel chatPanel;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private int type = 0 ;

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
        setResizable(false);
        setTitle("CSE443 HW3 DFT Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocation(400, 20);

        JButton btnNewButton = new JButton("with monitors");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logArea.append("\nwith monitor have chosen!");
                type = 1;
            }
        });
        btnNewButton.setBounds(77, 94, 89, 23);

        JButton btnNewButton_1 = new JButton("not with monitors");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logArea.append("\nnot with monitor have chosen!");
                type = 2;
            }
        });
        btnNewButton_1.setBounds(329, 94, 89, 23);

        contentPane1 = new MainJPanel();
        contentPane1.add(btnNewButton);
        contentPane1.add(btnNewButton_1);

        logArea = new JTextArea("Choose a method before start!", 8, 40);
        logArea.setEditable(false);
        logArea.setFocusable(false);
        chatScroll = new JScrollPane(logArea);
        chatPanel = new JPanel(new BorderLayout());
        chatPanel.add(new JLabel("Messages:", SwingConstants.LEFT), BorderLayout.PAGE_START);
        chatPanel.add(chatScroll);
        contentPane2 = new JPanel();
        contentPane2.setLayout(new BoxLayout(contentPane2, BoxLayout.PAGE_AXIS));
        contentPane2.add(Box.createVerticalStrut(10));
        contentPane2.add(contentPane1);

        btnNewButton_2 = new JButton("Start");
        /*btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(type == 0) {
                    JOptionPane.showMessageDialog(null, "Choose a method!"
                            , "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    logArea.append("\ntype: ");
                    logArea.append(String.valueOf(type));
                    SingleThread.main(null);
                    logArea.append("\nfinished");
                }

            }
        });*/
        btnNewButton_2.addActionListener(contentPane1);
        contentPane1.add(btnNewButton_2);

        btnNewButton_3 = new JButton("Cancel");
        /*btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(type == 0) {
                    JOptionPane.showMessageDialog(null, "Choose a method!"
                            , "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    logArea.append("\ntype: ");
                    logArea.append(String.valueOf(type));
                }
            }
        });*/
        btnNewButton_3.addActionListener(contentPane1);
        contentPane1.add(btnNewButton_3);
        contentPane2.add(chatPanel);
        setContentPane(contentPane2);



    }
    /***
     * Create a thread for game screen.
     */
    public void createThread() {
        try {
            //contentPanel object is runnable and
            //extends from JPanel class.
            panelThread = new Thread(contentPane1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * Start the thread
     */
    public void startThread() {
        panelThread.start();
    }
}

