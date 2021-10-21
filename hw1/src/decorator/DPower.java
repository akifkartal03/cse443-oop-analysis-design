package decorator;

import java.awt.Graphics;
import java.awt.Rectangle;

public class DPower extends PowerDecorator{

	public DPower() {
		super();
		setName("D");
		
		
	}

	@Override
	public int multiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		
		return "D";
	}

	

}
