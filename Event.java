
public abstract class Event {
	
	private double time;
	
	
	public abstract void doEvent();
	
	public double getTime() {
		return this.time;
	}
}
