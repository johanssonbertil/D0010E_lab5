

public class StopEvent extends Event {
	
	public StopEvent(State state, int time, EventQueue eventQueue){
		super(state, time, eventQueue);
	}
	
	public void doEvent() {
		state.setRunning(false);
	}
	
	
}
