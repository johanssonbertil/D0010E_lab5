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
    public double totalQueuingTime;
    public int peopleWhoHaveQueued;
    public double queuingPreviousTime;
    public double lastEventTime;
    public boolean queuingStarted = false;
    public boolean canEnter = true;
    public boolean stateChanged = false;
    public double checkoutsAvailableTotalTime;
    public double checkoutsAvailablePreviousTime;

    public CustomerFactory cFactory;
    public FIFO checkoutQueue;
    public UniformRandomStream uniPick, uniPay;
	public int totalCustomers;


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
	    		if(stateChanged) {
	    		totalCustomers++;
	    		currentCustomers++;
	    		}
	    		return true;
	    	}
    	} else {
    		return false;
    	}
    }
    public void updateTotalQueueingTime(Event e) {
    	totalQueuingTime += (e.getTime() - queuingPreviousTime) * checkoutQueue.getSize();
    	queuingPreviousTime = e.getTime();
    }
    public void updatecheckoutsAvailableTotalTime(Event e) {
    	checkoutsAvailableTotalTime += (e.getTime() - checkoutsAvailablePreviousTime) * availableCheckouts;
		checkoutsAvailablePreviousTime = e.getTime();
    }
}

