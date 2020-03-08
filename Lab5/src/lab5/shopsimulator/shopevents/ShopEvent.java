package lab5.shopsimulator.shopevents;
import lab5.genericsimulator.*;
import lab5.genericsimulator.EventQueue;
import lab5.genericsimulator.State;
import lab5.shopsimulator.customer.Customer;

public abstract class ShopEvent extends Event {
	public State  state;
	public Customer customer;
	int time;
	
	public ShopEvent (State state, double time, EventQueue eventQueue, Customer c) {
		super(state, time, eventQueue);
		customer = c;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}