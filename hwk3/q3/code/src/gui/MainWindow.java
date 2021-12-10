package gui;

import helper.SingleThread;
import monitors.TestDrive;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Stack;
import java.util.concurrent.ExecutionException;

public class MainWindow extends JFrame {

    private Stack<TakenTime> times;
    private JPanel contentPane1;
    private JPanel contentPane2;
    private JTextArea logArea;
    private JScrollPane chatScroll;
    private JPanel chatPanel;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private int type = 0;
    SwingWorker<Long, Void> calculator;
    private boolean isWorking = false;

    /**
     * Launch the application.
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

    /**
     * Create the frame.
     */
    public MainWindow() {
        setResizable(false);
        setTitle("CSE443 HW3 DFT Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocation(400, 20);
        times = new Stack<>();

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

        contentPane1 = new JPanel();
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


}

