package lab5.shopsimulator.shopevents;

import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.State;

import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.customer.Customer;

public class ArrivalEvent extends ShopEvent{
	
	private State state;
	private double time;
	public Customer customer;

	public ArrivalEvent (State state, double time, EventQueue eventQueue, Customer customer) {
		super(state, time, eventQueue, customer);
		this.state = state;
		this.time = time;
		this.customer = customer;
	
	}
	public void doEvent() {

		if (state.getRunning()) {
			ArrivalEvent event = new ArrivalEvent(state, state.expRNG.next() + time,  eventQueue, ((ShopState)state).cFactory.getNextCustomer());
			eventQueue.add(event);
			if (((ShopState)state).customerArrived()) { //Customer successfully entered the store.
				PickUpEvent pEvent = new PickUpEvent(state, state.uniRNG.next() + time, eventQueue, customer);
				eventQueue.add(pEvent);
			}
		}
		
	}


	public String name() {
		return "Ankomst";
	}

}
