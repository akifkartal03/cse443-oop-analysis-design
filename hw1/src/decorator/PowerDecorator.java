package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class PowerDecorator extends PowerUP{
	private PowerUP powertype; //has a relation
	protected int xStart;
	protected Rectangle powerArea;
	
	public abstract void draw(Graphics g);

	public PowerUP getPowertype() {
		return powertype;
	}

	public void setPowertype(PowerUP powertype) {
		this.powertype = powertype;
	}

	public int getxStart() {
		return xStart;
	}

	public void setxStart(int xStart) {
		this.xStart = xStart;
		powerArea.x = xStart;
	}

	public Rectangle getPowerArea() {
		return powerArea;
	}

	public void setPowerArea(Rectangle powerArea) {
		this.powerArea = powerArea;
	}
	
	
	
	
	
}
