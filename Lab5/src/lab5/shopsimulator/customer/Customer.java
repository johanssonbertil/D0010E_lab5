package lab5.shopsimulator.customer;

public class Customer {
	private int customerID;
	private double arrivalTime;
	
	Customer(int customerID){
		this.customerID = customerID;
	}
	
	public int getID() {
		return customerID;
	}
	
	public double getArrivalTime() {
		return arrivalTime;
	}
}