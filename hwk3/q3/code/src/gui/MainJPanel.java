package gui;

import helper.SingleThread;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainJPanel extends JPanel implements Runnable, ActionListener, MouseListener {
    private int FPS = 60;
    private int currentFPS = 60;

    @Override
    public void run() {
        double fpsMS = 1000000000 / FPS;
        double deltaTime = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long counter = 0;
        int numberOfDraw = 0;

        //game will continue until you exit
        while (true) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime) / fpsMS;
            counter += (currentTime - lastTime);
            lastTime = currentTime;

            if (deltaTime >= 1) {
                repaint();
                deltaTime--;
                numberOfDraw++;
            }

            if (counter >= 1000000000) {
                currentFPS = numberOfDraw;
                numberOfDraw = 0;
                counter = 0;
            }


        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        SingleThread.main(null);
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("released");
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("entered");
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("exited");
    }
}
