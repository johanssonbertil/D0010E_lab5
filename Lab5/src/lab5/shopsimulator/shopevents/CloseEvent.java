package lab5.shopsimulator.shopevents;

import lab5.genericsimulator.Event;
import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.State;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.customer.Customer;

public class CloseEvent extends Event {

	public CloseEvent(State state, double time, EventQueue eventQueue) {
		super(state, time, eventQueue);
		// TODO Auto-generated constructor stub
	}

	public void doEvent() {
		
	}

	public String name() {
		return "St�nger";
	}

	public void changeState() {
		((ShopState)state).canEnter = false;
	}


}
