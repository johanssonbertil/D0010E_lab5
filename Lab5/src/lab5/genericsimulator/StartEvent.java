package lab5.genericsimulator;

import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.shopevents.ArrivalEvent;

public class StartEvent extends Event {
	
	private State state;
	private ShopState shopState;
	private double time;
	
	public StartEvent(State state, double time, EventQueue eventQueue) {
		super(state, time, eventQueue);
		this.state = state;
		this.time = time;
	}

	public void doEvent() {
		
		shopState = ((ShopState)state);
		
		state.updateObs(this);
		
		if (state.getRunning()) {
			if(shopState.checkOutAvailable()) {
				shopState.updatecheckoutsAvailableTotalTime(time);
				
			} else {
				shopState.updateTotalQueueingTime(time);
			}
			
		}
		
		state.setRunning(true);
	}

	@Override
	public String name() {
		return "StartEvent";
	}

}
