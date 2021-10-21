package decorator;

import java.awt.Graphics;
import java.awt.Rectangle;

public class BPower extends PowerDecorator{

	public BPower() {
		super();
		setName("B");
		
		
	}
	public BPower(PowerUP powertype) {
		this();
		this.powertype = powertype;
	}

	@Override
	public long multiplier() {
		return getPowertype().multiplier()*5;
	}

	@Override
	public String getName() {
		return "B";
	}

	

}
