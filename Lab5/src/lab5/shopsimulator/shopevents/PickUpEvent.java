package lab5.shopsimulator.shopevents;

import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.Simulator;
import lab5.genericsimulator.State;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.ShopView;
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
    	
    	shopState.updatecheckoutsAvailableTotalTime(time);
    	shopState.updateTotalQueueingTime(time);
    	
        if(shopState.checkOutAvailable()){
        	
        	
        	shopState.updateObs(this);
        	
            PayEvent event = new PayEvent(state, shopState.uniPay.next() + time, eventQueue, customer);
            eventQueue.add(event);
            shopState.customerGoesToCheckout();
            
        } else {
        	
        	shopState.updateObs(this);
        	
        	shopState.checkoutQueue.add(customer);
            shopState.peopleWhoHaveQueued++;
        }
    }

    @Override
    public String name() {
        return "Plock";
    }

	
}
