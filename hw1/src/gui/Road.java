package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Road {
	
	private List<RoadStone> stoneList;
	private Random randomColor;
	
	public Road() {
		stoneList = new ArrayList<RoadStone>();
		randomColor = new Random();
		for(int i = 0; i < 13; i++) {
			RoadStone stone1 = new RoadStone();
			stone1.setX(i*50);
			stone1.setColor(getRandomColor());
			stoneList.add(stone1);
		}
	}
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(10f));
		
		for(RoadStone stone : stoneList) {
			g2.setColor(stone.getColor());
			g2.draw(new Line2D.Double(stone.getX(), 239, stone.getX()+51, 239));
		}
		
		/*Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(10f));
	    g2.setColor(Color.BLACK);
        g2.draw(new Line2D.Double(0, 239, 50, 239));
        g2.setColor(Color.GREEN);
        g2.draw(new Line2D.Double(50, 239, 100, 239));
        g2.setColor(Color.BLUE);
        g2.draw(new Line2D.Double(100, 239, 150, 239));
        g2.setColor(Color.ORANGE);
        g2.draw(new Line2D.Double(150, 239, 200, 239));*/
	}
	public void updateRoad(int distance) {
		for(RoadStone stone : stoneList) {
			stone.setX(stone.getX()-distance);
		}
		RoadStone stone2 = stoneList.get(0);
		if(stone2.getX() + 50 < 0) {
			stone2.setX(stoneList.get(stoneList.size() - 1).getX() + 50);
			stoneList.add(stone2);
			stoneList.remove(0);
		}
	}
	public Color getRandomColor() {
		int number = randomColor.nextInt(3);
		switch(number) {
		case 0:
			return Color.ORANGE;
		case 1:
			return Color.GREEN;
		default:
			return Color.BLUE;
		}
	}

}
