package decorator;

import java.awt.Graphics;
import java.awt.Rectangle;

public class DPower extends PowerDecorator{

	public DPower() {
		super();
		setName("D");
		
		
	}
	public DPower(PowerUP powertype) {
		this();
		this.powertype = powertype;
	}

	@Override
	public long multiplier() {
	
		return getPowertype().multiplier()*1;
	}

	@Override
	public String getName() {
		
		return "D";
	}

	

}
