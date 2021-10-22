package strategy;

public abstract class Character {
	
	private JumpBehavior jumpBehavior;
	
	public abstract void jumpChr(int distance);
	
	public abstract void fallChr(int distance);
	
	public void setJumpBehavior(JumpBehavior jumpBehavior) {
		this.jumpBehavior = jumpBehavior;
	}
	
	public JumpBehavior getJumpBehavior() {
		return jumpBehavior;
	}
	
	
}
