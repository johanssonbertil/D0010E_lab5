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
    public final int maxCustomers = 5;
    public int availableCheckouts;
    public final int totCheckouts = 2;
    public  double closeTime;
    public double totalQueuingTime = 0;
    public int peopleWhoHaveQueued = 0;
    public double queuingPreviousTime = 0;
    public double lastEventTime = 0;
    public boolean queuingStarted = false;
    public boolean canEnter = true;
    public double checkoutsAvailableTotalTime = 0;
    public double checkoutsAvailablePreviousTime = 0;

    public CustomerFactory cFactory;
    public FIFO checkoutQueue;
    public UniformRandomStream uniPick, uniPay;
	public int totalCustomers = 0;


    public ShopState(double maxT, ExponentialRandomStream exp, UniformRandomStream uni1, UniformRandomStream uni2){
    		super(maxT, exp, uni1);
    		uniPick = uni1;
    		uniPay = uni2;
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
	    		totalCustomers++;
	    		customersLeft++;
	    		return false;
	    		
	    	}
	    	else {
	    		totalCustomers++;
	    		currentCustomers++;
	    		return true;
	    	}
    	} else {
    		return false;
    	}
    }
    public void updateTotalQueueingTime(double time) {
    	totalQueuingTime += (time - queuingPreviousTime) * checkoutQueue.getSize();
    	queuingPreviousTime = time;
    }
    public void updatecheckoutsAvailableTotalTime(double time) {
    	checkoutsAvailableTotalTime += (time - checkoutsAvailablePreviousTime) * availableCheckouts;
		checkoutsAvailablePreviousTime = time;
    }
}

