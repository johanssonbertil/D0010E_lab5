package lab5.shopsimulator.shopevents;

import lab5.genericsimulator.Event;
import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.State;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.customer.Customer;

public class CloseEvent extends Event {

	private double time;
	public CloseEvent(State state, double time, EventQueue eventQueue) {
		super(state, time, eventQueue);
		this.time = time;
		// TODO Auto-generated constructor stub
	}

	public void doEvent() {
		
		
		((ShopState)state).updatecheckoutsAvailableTotalTime(time);	
		((ShopState)state).updateTotalQueueingTime(time);
		
		((ShopState)state).updateObs(this);
		
		((ShopState)state).canEnter = false;
	}

	public String name() {
		return "Stänger";
	}
}
