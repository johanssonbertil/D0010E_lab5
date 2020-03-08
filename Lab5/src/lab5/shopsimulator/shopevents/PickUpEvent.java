package lab5.shopsimulator.shopevents;

import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.State;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.customer.Customer;


public class PickUpEvent extends ShopEvent {
	
	private State state;
	private double time;
	public Customer customer;
	private ShopState shopState;
	
    public PickUpEvent(State state, double time, EventQueue eventQueue, Customer customer){
    	super(state, time, eventQueue, customer);
    	this.state = state;
    	this.time = time;
    	this.customer = customer;
    }
    public void doEvent(){
    	
    	shopState = ((ShopState)state);
    	
        if(shopState.checkOutAvailable()){
        	shopState.checkoutsAvailableTotalTime += time * shopState.availableCheckouts - shopState.checkoutsAvailableStartTime;
			shopState.checkoutsAvailableStartTime = time;
        	shopState.customerGoesToCheckout();
            PayEvent event = new PayEvent(state, shopState.uniPay.next() + time, eventQueue, customer);
            eventQueue.add(event);
        }
        else{
        	shopState.checkoutQueue.add(customer);
            if(!shopState.queuingStarted) {
            	shopState.queuingStartedTime = time;
            	shopState.queuingStarted = true;
            } else {
            	shopState.totalQueuingTime += time - shopState.queuingStartedTime;
            }
        }
    }

    @Override
    public String name() {
        return "Plock";
    }
}
