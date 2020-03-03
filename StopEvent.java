
public class StopEvent extends Event {
	
	private State state;
	
	public StopEvent(State state, int time){
		super(state, time);
	}
	
	public void doEvent() {
		state.setRunning(false);
	}
	
	
}
