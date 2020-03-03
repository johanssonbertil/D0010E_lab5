public abstract class ShoppingEvent extends Event {
	
	Customer customer;
	
	void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
