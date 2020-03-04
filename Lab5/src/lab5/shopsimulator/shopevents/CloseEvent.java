package lab5.shopsimulator.shopevents;

import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.State;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.customer.Customer;

public class CloseEvent extends ShopEvent {

	public CloseEvent(State state, double time, EventQueue eventQueue, Customer c) {
		super(state, time, eventQueue, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doEvent() {
		((ShopState)state).canEnter = false;
		
	}
	

}
