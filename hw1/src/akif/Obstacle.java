package akif;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Obstacle {
	
	private int xStart;
	private int yStart;
	private Rectangle obs;
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
		xStart = 200;
		yStart = 160;
		obs = new Rectangle();
		obs.width = 10;
		obs.height = 69;
		obs.x = xStart;
		obs.y = yStart;
	}
	
	public void updateObstacle(int distance) {
		xStart -= distance;
		obs.x = xStart;
		for(ObsPosition stone : positionList) {
			stone.setxStart(stone.getxStart()-distance);
		}
		ObsPosition stone2 = positionList.get(0);
		if(stone2.getxStart() + 11 < 0) {
			stone2.setxStart(positionList.get(positionList.size() - 1).getxStart() + getRandomPosition());
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
	
	public void draw(Graphics g) {
			
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10f));
		g2.setColor(Color.BLACK);
		for(ObsPosition obst : positionList) {
			g2.drawRect(obst.getxStart(), yStart, 5, 69);
		}
        //g2.draw(new Line2D.Double(xStart, yStart, xStart, 226));
        
		
			
	}
	
	public int getRandomPosition() {
		
		//get random number between 200-500
		return randomPosition.nextInt((501) - 300) + 300;
	}
	
	
}
