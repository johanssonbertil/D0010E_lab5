package lab5.genericsimulator;

public class StopEvent extends Event {
	
	public StopEvent(State state, double time, EventQueue eventQueue){
		super(state, time, eventQueue);
	}
	
	public void doEvent() {
		state.setRunning(false);
	}

	@Override
	public String name() {
		return "StopEvent";
	}


}