package decorator;

import java.awt.Graphics;
import java.awt.Rectangle;

public class CPower extends PowerDecorator{

	public CPower() {
		super();
		setName("C");
		
		
	}
	
	@Override
	public int multiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return "C";
	}

	

}
