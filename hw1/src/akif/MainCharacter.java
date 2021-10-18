package akif;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class MainCharacter {
	
	
	private Rectangle chr;
	private int yStart;
	
	public MainCharacter() {
	
		chr = new Rectangle();
		yStart = 204;
		chr.x = 150;
		chr.y = yStart;
		chr.width = 35;
		chr.height = 35;
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

}
