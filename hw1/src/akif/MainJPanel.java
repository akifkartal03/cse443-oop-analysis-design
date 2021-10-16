package akif;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MainJPanel extends JPanel implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void run() {
		while(true) {
		
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// intentionally empty
		//by author
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key Pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Key Released");
		
	}
	
}
