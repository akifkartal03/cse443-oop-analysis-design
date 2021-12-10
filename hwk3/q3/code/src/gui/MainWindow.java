package gui;

import helper.SingleThread;
import monitors.TestDrive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.concurrent.ExecutionException;


/***
 * This class extends from JFrame to create a GUI Window.
 */
public class MainWindow extends JFrame {

    SwingWorker<Long, Void> calculator;
    private final Stack<TakenTime> times;
    private final JPanel contentPane1;
    private final JPanel contentPane2;
    private final JTextArea logArea;
    private final JScrollPane chatScroll;
    private final JPanel chatPanel;
    private final JButton btnNewButton_2;
    private final JButton btnNewButton_3;
    private int type = 0;
    private boolean isWorking = false;

    /**
     * Constructor to initialize things
     */
    public MainWindow() {
        setResizable(false);
        setTitle("CSE443 HW3 DFT Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocation(400, 20);
        times = new Stack<>();

        /* Create first 2 button */
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

        //add them into frame
        contentPane1 = new JPanel();
        contentPane1.add(btnNewButton);
        contentPane1.add(btnNewButton_1);

        /* Create Log Panel */
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

        /* Create last 2 button(start and cancel) */
        btnNewButton_2 = new JButton("Start");
        //add action listener
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (type == 0) {
                    JOptionPane.showMessageDialog(null, "Choose a method!"
                            , "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    calculator = new SwingWorker<Long, Void>() {
                        @Override
                        public Long doInBackground() {
                            isWorking = true;

                            //logArea.append(String.valueOf(type));
                            if (type == 1) {
                                logArea.append("\nCalculation is started with monitors!");
                                Long start = System.currentTimeMillis();
                                TestDrive.main(null);
                                return System.currentTimeMillis() - start;
                            } else {
                                logArea.append("\nCalculation is started with single thread!");
                                Long start = System.currentTimeMillis();
                                SingleThread.main(null);
                                return System.currentTimeMillis() - start;
                            }
                        }

                        @Override
                        protected void done() {
                            try {
                                isWorking = false;
                                if (!calculator.isCancelled()) {
                                    logArea.append("\nCalculation is finished!");
                                    Long res = get();
                                    if (type == 1) {
                                        logArea.append("\nTime Taken with monitors is: ");
                                        logArea.append(String.valueOf(res));
                                        logArea.append(" ms");
                                        if (!times.empty()) {
                                            TakenTime t = times.peek();
                                            if (t.getType() != type) {
                                                String str = String.valueOf(t.getDiffer(t, new TakenTime(1, res)));
                                                logArea.append("\nTotal gained time with threads is: ");
                                                logArea.append(str);
                                                logArea.append(" ms");
                                                JOptionPane.showMessageDialog(null, "Total gained time with threads is\n" +
                                                                str + " ms"
                                                        , "Result", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        }
                                        times.push(new TakenTime(1, res));
                                    } else {
                                        logArea.append("\nTime Taken with single thread is: ");
                                        logArea.append(String.valueOf(res));
                                        logArea.append(" ms");
                                        if (!times.empty()) {
                                            TakenTime t = times.peek();
                                            if (t.getType() != type) {
                                                String str = String.valueOf(t.getDiffer(new TakenTime(2, res), t));
                                                logArea.append("\nTotal gained time with threads is: ");
                                                logArea.append(str);
                                                logArea.append(" ms");
                                                JOptionPane.showMessageDialog(null, "Total gained time with threads is\n" +
                                                                str + " ms"
                                                        , "Result", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        }
                                        times.push(new TakenTime(2, res));
                                    }

                                }
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            } catch (ExecutionException ex) {
                                ex.printStackTrace();
                            }
                        }
                    };
                    calculator.execute();

                }

            }
        });
        contentPane1.add(btnNewButton_2);

        btnNewButton_3 = new JButton("Cancel");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (type == 0) {
                    JOptionPane.showMessageDialog(null, "Choose a method!"
                            , "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (isWorking) {
                        logArea.append("\nCalculation is cancelled!: " + calculator.cancel(false));
                    } else {
                        JOptionPane.showMessageDialog(null, "Nothing is working to cancel!"
                                , "Warning", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        contentPane1.add(btnNewButton_3);
        contentPane2.add(chatPanel);
        setContentPane(contentPane2);

    }

    /**
     * Create window and start
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

