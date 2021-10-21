package decorator;

public abstract class PowerUP {
	private String name = "Unknown name";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract int multiplier();
	
}
