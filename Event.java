
public abstract class Event {
	
	private double time;
	
	private State state;
	
	private EventQueue eventQueue;
	
	public Event(State state, int time, EventQueue eventQueue){
		this.state = state;
		this.time = time;
		this.eventQueue = eventQueue;
	}

	public abstract void doEvent();
	
	public double getTime() {
		return this.time;
	}
}
