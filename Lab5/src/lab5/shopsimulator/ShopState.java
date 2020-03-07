package lab5.shopsimulator;


import lab5.shopsimulator.customer.Customer;
import lab5.shopsimulator.customer.CustomerFactory;
import lab5.genericsimulator.*;
import lab5.genericsimulator.random.ExponentialRandomStream;
import lab5.genericsimulator.random.UniformRandomStream;
public class ShopState extends State {
    public int currentCustomers = 0;
    public int successfulCustomers = 0;
    public int customersLeft = 0;
    public final int maxCustomers = 50;
    public int availableCheckouts;
    public final int totCheckouts = 4;
    public  double closeTime;
    public double totalQueuingTime;
    public int peopleWhoHaveQueued;
    public double queuingStartedTime;
    public boolean queuingStarted = false;
    public boolean canEnter = true;
    public double checkoutsAvailableTotalTime;

    public CustomerFactory cFactory;
    public FIFO checkoutQueue;


    public ShopState(double maxT, ExponentialRandomStream exp, UniformRandomStream uni){
    		super(maxT, exp, uni);
    		cFactory = new CustomerFactory();
    		checkoutQueue = new FIFO();
    		availableCheckouts = totCheckouts;
    }

    public boolean checkOutAvailable() {
        return !(availableCheckouts == 0);
    }

    public void customerGoesToCheckout(){
        availableCheckouts--;
    }

    public void customerLeavesCheckout(){
    	successfulCustomers++;
        availableCheckouts++;
        currentCustomers--;
    }
    
    public boolean customerArrived() { //Returns true if the customer successfully entered the store.
    	if(canEnter) {
	    	if (currentCustomers >= maxCustomers) {
	    		customersLeft++;
	    		return false;
	    		
	    	}
	    	else {
	    		currentCustomers++;
	    		return true;
	    	}
    	} else {
    		return false;
    	}
    }
    public void anotherCheckoutAvailable() {
    	availableCheckouts++;
    }


}

