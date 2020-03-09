package lab5.genericsimulator;




public abstract class Event {
	
	private double time;
	
	public State state;
	
	public EventQueue eventQueue;
	
	public Event(State state, double time, EventQueue eventQueue){
		this.state = state;
		this.time = time;
		this.eventQueue = eventQueue;
	}

	public abstract void doEvent();

	public abstract String name();
	
	public double getTime() {
		return this.time;
	}
}