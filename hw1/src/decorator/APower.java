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
	
	@Override
	public int multiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return "A";
	}



}
