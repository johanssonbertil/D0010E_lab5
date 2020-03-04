package lab5.shopsimulator.shopevents;

import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.State;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.customer.Customer;

public class PayEvent extends ShopEvent {

    public PayEvent(State state, double time, EventQueue eventQueue, Customer customer) {
    	super(state, time, eventQueue, customer);

    }

    public void doEvent(){
    	
    	((ShopState)state).customerLeavesCheckout();
    	if(!((ShopState)state).checkoutQueue.isEmpty()) {
    		Customer nextCustomer = ((ShopState)state).checkoutQueue.first();
    		((ShopState)state).checkoutQueue.removeFirst();
    		PayEvent event = new PayEvent(state, state.uniRNG.next(), eventQueue, nextCustomer);
            eventQueue.add(event);
            ((ShopState)state).peopleWhoHaveQueued++;
    	} else {
    		((ShopState)state).totalQueuingTime += time - ((ShopState)state).queuingStartedTime;
    		((ShopState)state).anotherCheckoutAvailable();
    		
    	}
    }

}
