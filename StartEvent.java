
public class StartEvent extends Event {
	
	private State state;
	
	public StartEvent(State state, int time) {
		super(state, time);
	}

	public void doEvent() {
		state.setRunning(true);
	}
	
}
