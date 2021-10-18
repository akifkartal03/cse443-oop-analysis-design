package akif;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

enum GameState{
	Start, Playing, Finished;
}

public class MainJPanel extends JPanel implements Runnable, KeyListener{
	
	GameState state = GameState.Start;
	private int x = 0;
	private int y = 0;
	private int FPS= 60;
	private int currentFPS= 60;
	MainCharacter character;
	private Road road;
	private Obstacle obs;
	private JTextArea logPanel;
	private boolean isJumped = false;
	
	
	public MainJPanel(JTextArea logArea) {
		super(new BorderLayout());
		road = new Road();
		obs = new Obstacle();
		character = new MainCharacter();
		this.logPanel = logArea;
		//System.out.println(logPanel.getText());
		
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
				//road.updateRoad();
				/*if(obs.isIntersects(character.getCharacter())) {
					System.out.println("inter");
					logPanel.append("\ninter");
				}*/
				repaint();
				deltaTime--;
				numberOfDraw++;
			}
			
			if(counter >= 1000000000) {
				//System.out.println("FPS: " + numberOfDraw);
				currentFPS = numberOfDraw;
				numberOfDraw = 0;
				counter = 0;
			}
		
			
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//parameters: x, y, width, height
		//g.drawRect(100, 100, 100, 100);
		//g.drawOval(5, 204, 50, 50);
		g.setColor(Color.BLACK);
		g.drawString("FPS: " + currentFPS, 10, 20);
		//g.drawLine(0, 60, 180, 60);
		//Graphics2D g2 = (Graphics2D) g;
	    //g2.setStroke(new BasicStroke(5f));
	    //g2.setColor(Color.BLACK);
        //g2.draw(new Line2D.Double(507, 0, 507, 234));
        //g2.setStroke(new BasicStroke(3f));
        //g2.setColor(Color.decode("#f84545"));
        //g2.fill(new Ellipse2D.Double(15, 204, 30, 30));
		character.draw(g);
        road.draw(g);
        obs.draw(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// intentionally empty
		//by author
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("Key Pressed");
		//logPanel.append("\nKey Pressed");
		
		if(obs.isIntersects(character.getCharacter())) {
			System.out.println("inter");
			logPanel.append("\ninter");
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE && !isJumped) {
			character.jump(55);
			character.jump(30);
			road.updateRoad(5);
			obs.updateObstacle(5);
			isJumped = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			road.updateRoad(5);
			obs.updateObstacle(5);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(obs.isIntersects(character.getCharacter())) {
			//System.out.println("inter");
			logPanel.append("\ninter");
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			road.updateRoad(5);
			obs.updateObstacle(80);
			character.unjump(30);
			character.unjump(55);
			isJumped = false;
		}
		
	}
	
}
