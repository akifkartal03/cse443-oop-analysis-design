package strategy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import decorator.PowerUP;

public class MainCharacter  {
	
	private JumpBehavior jumpBehavior;
	private int totalPoint;
	private int totalLife;
	private Coordinates cor;
	
	public MainCharacter() {
		jumpBehavior = new LowJump();
		totalLife = 3;
		totalPoint = 0;
		cor = new Coordinates();
	}
	
	public void setJumpBehavior(JumpBehavior jumpBehavior) {
		this.jumpBehavior = jumpBehavior;
	}
	
	public Rectangle getCharacter() {
		return cor.getChr();
	}
	
	public Coordinates getCoordinates() {
		return cor;
	}
	
	
	public void draw(Graphics g) {
			
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3f));
        g2.setColor(Color.decode("#f84545"));
        g2.fill(new Ellipse2D.Double(150, cor.getyStart(), 30, 30));	
	}
	public void decrementLife() {
		totalLife--;
	}
	public void incremetPoint(int point) {
		totalPoint+=point;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	
	public int getTotalLife() {
		return totalLife;
	}
	
	

	public JumpBehavior getJumpBehavior() {
		return jumpBehavior;
	}

	
	
	

}
