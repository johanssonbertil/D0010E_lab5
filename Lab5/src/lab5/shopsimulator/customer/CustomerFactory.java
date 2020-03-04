package lab5.shopsimulator.customer;

public class CustomerFactory {
	
	private int customerNR = 0;
	
	public Customer getNextCustomer() {
		customerNR++;
		return new Customer(customerNR);
		
	}
	
}