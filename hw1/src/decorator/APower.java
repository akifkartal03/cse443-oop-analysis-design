package decorator;

import java.awt.Graphics;
import java.awt.Rectangle;

public class APower extends PowerDecorator{

	public APower() {
		setName("A");
		xStart = 500;
		powerArea = new Rectangle();
		powerArea.width = 20;
		powerArea.height = 20;
		powerArea.x = xStart;
		powerArea.y = 160;
		
	}
	
	@Override
	public int multiplier() {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
