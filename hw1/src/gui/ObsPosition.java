package gui;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class ObsPosition {
	private int xStart;
	private Rectangle obs;
	
	public ObsPosition() {
		xStart = 200;
		obs = new Rectangle();
		obs.width = 10;
		obs.height = 69;
		obs.x = xStart;
		obs.y = 160;
	}

	public ObsPosition(int xStart, Rectangle obs) {
		this.xStart = xStart;
		this.obs = obs;
	}

	public int getxStart() {
		return xStart;
	}

	public void setxStart(int xStart) {
		this.xStart = xStart;
		obs.x = xStart;
	}

	public Rectangle getObs() {
		return obs;
	}

	public void setObs(Rectangle obs) {
		this.obs = obs;
	}
	
	
	
	
}
