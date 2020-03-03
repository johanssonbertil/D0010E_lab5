
public class StopEvent extends Event {
	
	private State state;
	
	private EventQueue eventQueue;
	
	public StopEvent(State state, int time, EventQueue eventQueue){
		super(state, time, eventQueue);
	}
	
	public void doEvent() {
		state.setRunning(false);
	}
	
	
}
