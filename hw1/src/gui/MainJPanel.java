package gui;

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

import decorator.APower;
import decorator.BPower;
import decorator.CPower;
import decorator.DPower;
import decorator.PowerDecorator;
import decorator.PowerUP;
import decorator.Score;
import strategy.HighJump;
import strategy.MainCharacter;

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
	private DrawPower powers;
	private PowerUP score;
	private JTextArea logPanel;
	private int distance = 55;
	private int distance2 = 45;
	private boolean isJumped = false;
	private boolean isGameOver = false;
	
	public MainJPanel(JTextArea logArea) {
		super(new BorderLayout());
		road = new Road();
		obs = new Obstacle();
		character = new MainCharacter();
		powers = new DrawPower();
		score = new Score();
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
				if(character.getTotalLife() <= 0 && !isGameOver) {
					//Finish game heree.
					logPanel.append("\nGame Over");
					isGameOver = true;
				}
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
		g.drawString("Life: " + character.getTotalLife(), 460, 15);
		g.drawString("Score Multiplier : " + score.multiplier(), 10, 40);
		g.drawString("Total Point: " + character.getTotalPoint(), 460, 35);
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
        powers.draw(g);
        
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// intentionally empty
		// by author akif
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("Key Pressed");
		//logPanel.append("\nKey Pressed");
		
		if(obs.isIntersects(character.getCharacter()) && distance2 > 40 ) {
			//System.out.println("inter");
			if(character.getTotalLife() > 0) {
				logPanel.append("\nYou lost a life.");
				character.decrementLife();
			}
			else {
				logPanel.append("\nGame Over");
				isGameOver = true;
			}
			distance2 = 0;
		}
		PowerDecorator result = powers.isIntersects(character.getCharacter());
		if(result != null && distance > 50) {
			//character = 
			wrapCharacter(result);
			logPanel.append("\n" + result.getName() + " power acquired.");
			distance = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE && !isJumped) {
			character.getJumpBehavior().jump(character.getCoordinates(), 55);
			character.getJumpBehavior().jump(character.getCoordinates(), 30);
			logPanel.append("\n" + character.getJumpBehavior().getType());
			road.updateRoad(5);
			obs.updateObstacle(5);
			powers.updatePowers(5);
			isJumped = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			road.updateRoad(5);
			obs.updateObstacle(5);
			powers.updatePowers(5);
			distance+=5;
			distance2+=5;
		}
		obs.resolveOverLaps(powers.getPowerList());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(obs.isIntersects(character.getCharacter()) && distance2 > 40) {
			if(character.getTotalLife() > 0) {
				logPanel.append("\nYou lost a life.");
				character.decrementLife();
			}
			else {
				logPanel.append("\nGame Over");
				isGameOver = true;
			}
			distance2 = 0;
		}
		PowerDecorator result = powers.isIntersects(character.getCharacter());
		if(result != null && distance > 50) {
			wrapCharacter(result);
			logPanel.append("\n" + result.getName() + " power acquired.");
			distance = 0;
		}
	
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			road.updateRoad(5);
			obs.updateObstacle(80);
			powers.updatePowers(80);
			character.getJumpBehavior().fall(character.getCoordinates(), 30);
			character.getJumpBehavior().fall(character.getCoordinates(), 55);
			isJumped = false;
		}
		obs.resolveOverLaps(powers.getPowerList());
		
	}
	public void wrapCharacter(PowerDecorator pwrType) {
		
		switch(pwrType.getName()) {
		case "A":
			score = new APower(score);
			break;
		case "B":
			score = new BPower(score);
			break;
		case "C":
			score = new CPower(score);
			break;
		case "D":
			character.setJumpBehavior(new HighJump());
			break;
		default:
		}
	}
}
