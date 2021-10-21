package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import gui.ObsPosition;

public class APower extends PowerDecorator{

	public APower() {
		super();
		setName("A");
		
		
	}
	
	public APower(PowerUP powertype) {
		this();
		this.powertype = powertype;
	}
	
	@Override
	public long multiplier() {
		return getPowertype().multiplier()*2;
	}

	@Override
	public String getName() {
		return "A";
	}



}
