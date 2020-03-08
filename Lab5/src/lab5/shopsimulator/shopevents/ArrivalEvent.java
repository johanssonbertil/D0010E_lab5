package lab5.shopsimulator.shopevents;

import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.State;

import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.customer.Customer;

public class ArrivalEvent extends ShopEvent{
	
	private State state;
	private double time;
	public Customer customer;
	private ShopState shopState;

	public ArrivalEvent (State state, double time, EventQueue eventQueue, Customer customer) {
		super(state, time, eventQueue, customer);
		this.state = state;
		this.time = time;
		this.customer = customer;
	
	}
	public void doEvent() {
		
		shopState = ((ShopState)state);

		if (state.getRunning()) {
			if(shopState.checkOutAvailable()) {
				shopState.checkoutsAvailableTotalTime += time * shopState.availableCheckouts - shopState.checkoutsAvailableStartTime;
				shopState.checkoutsAvailableStartTime = time;
				
			} else {
				shopState.totalQueuingTime += time - shopState.queuingStartedTime;
			}
			if(shopState.canEnter) {
				ArrivalEvent event = new ArrivalEvent(state, state.expRNG.next() + time,  eventQueue, shopState.cFactory.getNextCustomer());
				eventQueue.add(event);
			}
			
			if (shopState.customerArrived()) { //Customer successfully entered the store.
				PickUpEvent pEvent = new PickUpEvent(state, shopState.uniPick.next() + time, eventQueue, customer);
				eventQueue.add(pEvent);
			}
		}
		
	}


	public String name() {
		return "Ankomst";
	}

}
