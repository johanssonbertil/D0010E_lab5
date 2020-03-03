
public abstract class Event {
	
	private double time;
	
	private State state;
	
	public Event(State state, int time){
		this.state = state;
		this.time = time;
	}

	public abstract void doEvent();
	
	public double getTime() {
		return this.time;
	}
}

