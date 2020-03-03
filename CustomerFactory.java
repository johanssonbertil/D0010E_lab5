
public class CustomerFactory {
	
	private int customerNR = 0;
	
	public Customer getNextCustomer() {
		return new Customer(customerNR);
		customerNR++;
	}
	
}
