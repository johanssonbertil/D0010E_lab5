package lab5.genericsimulator;

public class StopEvent extends Event {
	
	private State state;
	
	public StopEvent(State state, double time, EventQueue eventQueue){
		super(state, time, eventQueue);
		this.state = state;
	}
	
	public void doEvent() {
		
		state.setRunning(false);
		
		state.updateObs(this);
		
		
	}

	@Override
	public String name() {
		return "StopEvent";
	}

}