package lab5.shopsimulator.shopevents;

import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.State;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.customer.Customer;

public class PayEvent extends ShopEvent {
	
	private State state;
	private double time;
	private ShopState shopState;

    public PayEvent(State state, double time, EventQueue eventQueue, Customer customer) {
    	super(state, time, eventQueue, customer);
    	this.state = state;
    	this.time = time;

    }

    public void doEvent(){
    	shopState = ((ShopState)state);
    	
		shopState.updatecheckoutsAvailableTotalTime(time);
		shopState.updateTotalQueueingTime(time);
			
    	shopState.updateObs(this);
    	
    	
    	if(!shopState.checkoutQueue.isEmpty()) {
    		Customer nextCustomer = shopState.checkoutQueue.first();
    		shopState.checkoutQueue.removeFirst();
    		
    		PayEvent event = new PayEvent(state, shopState.uniPay.next() + time, eventQueue, nextCustomer);
            eventQueue.add(event);
            shopState.customerGoesToCheckout();
    	}
    	shopState.customerLeavesCheckout();
    }

	
	public String name() {
		return "Betalning";
	}


}