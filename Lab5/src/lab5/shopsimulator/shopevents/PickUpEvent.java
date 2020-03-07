package lab5.shopsimulator.shopevents;

import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.State;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.customer.Customer;


public class PickUpEvent extends ShopEvent {
	
	private State state;
	private double time;
	
    public PickUpEvent(State state, double time, EventQueue eventQueue, Customer customer){
    	super(state, time, eventQueue, customer);
    	this.state = state;
    	this.time = time;
    }
    public void doEvent(){
    	
        if(((ShopState)state).checkOutAvailable()){
        	((ShopState)state).customerGoesToCheckout();
            PayEvent event = new PayEvent(state, state.uniRNG.next() + time, eventQueue, customer);
            eventQueue.add(event);
        }
        else{
            ((ShopState)state).checkoutQueue.add(customer);
            if(!((ShopState)state).queuingStarted) {
            	((ShopState)state).queuingStartedTime = time;
      
            }
        }
    }

    @Override
    public String name() {
        return "PickUpEvent";
    }
}
