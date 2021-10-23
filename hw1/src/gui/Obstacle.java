package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import decorator.PowerDecorator;

public class Obstacle {
	
	private List<ObsPosition> positionList;
	private Random randomPosition;
	
	public Obstacle() {
		positionList = new ArrayList<ObsPosition>();
		randomPosition = new Random();
		for(int i = 0; i < 5; i++) {
			ObsPosition obs1 = new ObsPosition();
			obs1.setxStart((i+1)*getRandomPosition());
			positionList.add(obs1);
		}
	}
	
	public void updateObstacle(int distance) {
	
		for(ObsPosition stone : positionList) {
			stone.setxStart(stone.getxStart()-distance);
		}
		ObsPosition stone2 = positionList.get(0);
		if(stone2.getxStart() + 11 < 0) {
			stone2.setxStart(positionList.get(positionList.size() - 1).getxStart() + getRandomPosition() + 20);
			positionList.add(stone2);
			positionList.remove(0);
		}
	}
	
	public boolean isIntersects(Rectangle chr) {
		for(ObsPosition stone : positionList) {
			//list.add(stone.getObs());
			if(stone.getObs().intersects(chr)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isTrueJump(int xPosition) {
		for(ObsPosition stone : positionList) {
			//list.add(stone.getObs());
			if(xPosition - stone.getObs().x < 60 && xPosition - stone.getObs().x > 0) {
				return true;
			}
		}
		return false;
	}
	
	public void resolveOverLaps(List<PowerDecorator> powerList) {
		for(PowerDecorator power1 : powerList) {
			for(ObsPosition obs1 : positionList) {
				if(power1.getPowerArea().intersects(obs1.getObs())){
					power1.setxStart(power1.getxStart()+70);
				}
			}
		}
		
	}
	/*
	 * 
	 * */
	
	public void draw(Graphics g) {
			
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10f));
		g2.setColor(Color.BLACK);
		for(ObsPosition obst : positionList) {
			g2.drawRect(obst.getxStart(), 160, 5, 69);
		}
        //g2.draw(new Line2D.Double(xStart, yStart, xStart, 226));
        
		
			
	}
	
	public int getRandomPosition() {
		
		//get random number between 300-600
		return randomPosition.nextInt((601) - 300) + 300;
	}
	
	
}
