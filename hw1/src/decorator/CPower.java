package decorator;

import java.awt.Graphics;
import java.awt.Rectangle;

public class CPower extends PowerDecorator{

	public CPower() {
		super();
		setName("C");
		
		
	}
	public CPower(PowerUP powertype) {
		this();
		this.powertype = powertype;
	}
	
	@Override
	public long multiplier() {
		return getPowertype().multiplier()*10;
	}

	@Override
	public String getName() {
		return "C";
	}

	

}
