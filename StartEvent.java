

public class StartEvent extends Event {
	
	public StartEvent(State state, int time, EventQueue eventQueue) {
		super(state, time, eventQueue);
	}

	public void doEvent() {
		state.setRunning(true);
	}
	
}

