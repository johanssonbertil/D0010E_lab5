package lab5.genericsimulator;


public class StartEvent extends Event {
	
	public StartEvent(State state, double time, EventQueue eventQueue) {
		super(state, time, eventQueue);
	}

	public void doEvent() {
		state.setRunning(true);
	}

	@Override
	public String name() {
		return "StartEvent";
	}

}
