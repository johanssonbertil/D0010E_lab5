package lab5.shopsimulator.customer;

public class Customer {
	private int customerID;
	private double arrivalTime;
//	private double queuingStartTime;
	
	Customer(int customerID){
		this.customerID = customerID;
	}
	
	public int getID() {
		return customerID;
	}
	
	public double getArrivalTime() {
		return arrivalTime;
	}
//	public void setQueuingStartTime(double time) {
//		queuingStartTime = time;
//	}
}