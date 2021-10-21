package decorator;

import java.awt.Graphics;
import java.awt.Rectangle;

public class BPower extends PowerDecorator{

	public BPower() {
		super();
		setName("B");
		
		
	}

	@Override
	public int multiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return "B";
	}

	

}
