package akif;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

enum GameState{
	Start, Playing, Finished;
}

public class MainJPanel extends JPanel implements Runnable, KeyListener{
	
	GameState state = GameState.Start;
	private int x = 0;
	private int y = 0;
	private int FPS= 60;
	private Road road;
	
	public MainJPanel() {
		road = new Road();
	}

	@Override
	public void run() {
		double fpsMS = 1000000000/FPS;
		double deltaTime = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long counter = 0;
		int numberOfDraw = 0;
		while(true) {
			currentTime = System.nanoTime();
			deltaTime += (currentTime - lastTime) / fpsMS;
			counter+= (currentTime - lastTime);
			lastTime = currentTime;
			
			if(deltaTime >= 1) {
				//update
				//repaint
				road.updateRoad();
				repaint();
				deltaTime--;
				numberOfDraw++;
			}
			
			if(counter >= 1000000000) {
				System.out.println("FPS: " + numberOfDraw);
				numberOfDraw = 0;
				counter = 0;
			}
		
			
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		//parameters: x, y, width, height
		//g.drawRect(100, 100, 100, 100);
		//g.drawOval(5, 204, 50, 50);
		//g.setColor(Color.BLACK);
		//g.drawLine(0, 60, 180, 60);
		Graphics2D g2 = (Graphics2D) g;
	    //g2.setStroke(new BasicStroke(5f));
	    //g2.setColor(Color.BLACK);
        //g2.draw(new Line2D.Double(507, 0, 507, 234));
        g2.setStroke(new BasicStroke(3f));
        g2.setColor(Color.decode("#f84545"));
        g2.fill(new Ellipse2D.Double(5, 204, 30, 30));
        road.draw(g2);
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
