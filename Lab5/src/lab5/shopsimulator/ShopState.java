package lab5.shopsimulator;


import lab5.shopsimulator.customer.Customer;
import lab5.shopsimulator.customer.CustomerFactory;
import lab5.genericsimulator.*;
import lab5.genericsimulator.random.ExponentialRandomStream;
import lab5.genericsimulator.random.UniformRandomStream;
public class ShopState extends State {
    private int currentCustomers = 0;
    private int successfulCustomers = 0;
    private int customersLeft = 0;
    private final int maxCustomers = 50;
    private int availableCheckouts;
    private final int totCheckouts = 4;
    public  double closeTime;
    public double totalQueuingTime;
    public int peopleWhoHaveQueued;
    public double queuingStartedTime;
    public boolean queuingStarted = false;
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
    	if (currentCustomers >= maxCustomers) {
    		customersLeft++;
    		return false;
    		
    	}
    	else {
    		currentCustomers++;
    		return true;
    	}
    }


}

