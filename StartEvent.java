
public class StartEvent extends Event {
	
	private State state;
	
	private EventQueue eventQueue;
	
	public StartEvent(State state, int time, EventQueue eventQueue) {
		super(state, time, eventQueue);
	}

	public void doEvent() {
		state.setRunning(true);
	}
	
}
