package strategy;

public interface JumpBehavior {
	
	public void jump(Coordinates coor, int distance);
	public void fall(Coordinates coor, int distance);
	public String getType();

}
