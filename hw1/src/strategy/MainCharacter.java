package strategy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import decorator.PowerUP;

public class MainCharacter extends PowerUP {
	
	private JumpBehavior jumpBehavior;
	private Rectangle chr;
	private int yStart;
	private int totalPoint;
	private int totalLife;
	
	public MainCharacter() {
		jumpBehavior = new LowJump();
		chr = new Rectangle();
		yStart = 204;
		chr.x = 150;
		chr.y = yStart;
		chr.width = 35;
		chr.height = 35;
		totalLife = 3;
		totalPoint = 0;
		setName("Red Ball 443");
	}
	
	public void setJumpBehavior(JumpBehavior jumpBehavior) {
		this.jumpBehavior = jumpBehavior;
	}
	
	public Rectangle getCharacter() {
		return chr;
	}
	
	public void jump(int distance) {
		yStart -= distance;
		chr.y = yStart;		
	}
	public void unjump(int distance) {
		yStart += distance;
		chr.y = yStart;	
	}
	
	public void draw(Graphics g) {
			
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3f));
        g2.setColor(Color.decode("#f84545"));
        g2.fill(new Ellipse2D.Double(150, yStart, 30, 30));	
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

	

	@Override
	public int multiplier() {
		//default multiplier is 1 for character
		return 1;
	}

	
	

}
