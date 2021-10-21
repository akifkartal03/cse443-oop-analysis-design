package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import decorator.APower;
import decorator.BPower;
import decorator.CPower;
import decorator.DPower;
import decorator.PowerDecorator;

public class DrawPower {

	private List<PowerDecorator> powerList;
	private Random randomPosition;
	
	public DrawPower() {
		powerList = new ArrayList<PowerDecorator>();
		randomPosition = new Random();
		
		initPowers();
		
		
	}
	
	public void initPowers() {
		
		for(int i = 0; i < 5; i++) {
			PowerDecorator power1 = getRandomPower();
			power1.setxStart((i+1)*getRandomPosition());
			powerList.add(power1);
		}
	}
	
	public void updatePowers(int distance) {

		for(PowerDecorator stone : powerList) {
			stone.setxStart(stone.getxStart()-distance);
		}
		PowerDecorator stone2 = powerList.get(0);
		if(stone2.getxStart() + 21 < 0) {
			stone2 = getRandomPower();
			stone2.setxStart(powerList.get(powerList.size() - 1).getxStart() + getRandomPosition());
			powerList.add(stone2);
			powerList.remove(0);
		}
		
	}
	
	public boolean isIntersects(Rectangle chr) {
		for(PowerDecorator stone : powerList) {
			//list.add(stone.getObs());
			if(stone.getPowerArea().intersects(chr)) {
				return true;
			}
		}
		return false;
	}
	
	public void draw(Graphics g) {
			
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1f));
		g2.setColor(Color.BLACK);
		for(PowerDecorator obst : powerList) {
			//g2.drawRect(obst.getxStart(), yStart, 5, 69);
			g.drawString(obst.getName(), obst.getxStart() + 7, 228);
			g2.draw(obst.getPowerArea());
		}
        //g2.draw(new Line2D.Double(xStart, yStart, xStart, 226));
		//Collections.shuffle(powerList);
		
			
	}
	
	public int getRandomPosition() {
		
		//get random number between 400-800
		return randomPosition.nextInt((800) - 400) + 400;
	}
	
	public PowerDecorator getRandomPower() {
		
		int rnd = randomPosition.nextInt(4);
		switch(rnd) {
		case 0:
			return new APower();
		case 1:
			return new BPower();
		case 2:
			return new CPower();
		case 3:
			return new DPower();
		default:
			return new CPower();
		}
	}

	public List<PowerDecorator> getPowerList() {
		return powerList;
	}

	
	
	
}
