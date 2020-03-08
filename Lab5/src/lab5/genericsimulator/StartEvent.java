package lab5.genericsimulator;

import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.shopevents.ArrivalEvent;

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

	@Override
	public void changeState() {
		state.setRunning(true);
		
	}

}
