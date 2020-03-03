
public class Customer {
	private int customerID;
	private int arrivalTime;
	
	Customer(int customerID){
		this.customerID = customerID;
	}
	
	public int getID() {
		return customerID;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
}
