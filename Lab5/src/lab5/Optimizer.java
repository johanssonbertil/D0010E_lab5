package lab5;

import java.util.Random;

import lab5.genericsimulator.Simulator;
import lab5.genericsimulator.StartEvent;
import lab5.genericsimulator.StopEvent;
import lab5.genericsimulator.random.ExponentialRandomStream;
import lab5.genericsimulator.random.UniformRandomStream;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.shopevents.ArrivalEvent;
import lab5.shopsimulator.shopevents.CloseEvent;

public class Optimizer {
	
	public void run() {
		method1(2, 1234, 5);
		//System.out.println("Greatest Least amount of checkouts: " + method3(13));
	}
	private ShopState method1(int checkouts, int seed, int maxCustomers) {
		
		
		ExponentialRandomStream expR = new ExponentialRandomStream(1.0, seed); // Skapar alla instanser av objekt som används
		UniformRandomStream uniPick = new UniformRandomStream(0.5, 1.0, seed);
		UniformRandomStream uniPay = new UniformRandomStream(2.0, 3.0, seed);
		ShopState state  = new ShopState(1000, expR, uniPick, uniPay, checkouts, maxCustomers);
		Simulator sim = new Simulator(state);
		sim.getEventQueue().add(new StartEvent(state, 0, sim.getEventQueue()));
		sim.getEventQueue().add(new ArrivalEvent(state, state.expRNG.next(), sim.getEventQueue(), state.cFactory.getNextCustomer()));
		sim.getEventQueue().add(new CloseEvent(state, 10.0, sim.getEventQueue()));
		sim.getEventQueue().add(new StopEvent(state, 999, sim.getEventQueue()));
		sim.run();
		
		return state;
	}
	
	private int method2(int seed) {

		int maxCustomer = 10;
		int checkOuts = 1;
		ShopState state;
		int optimalCheckOutAmount = Integer.MAX_VALUE;
		int successfullCustomers = 0;
		while (true) {
			state = method1(checkOuts, seed, maxCustomer);
			if (state.successfulCustomers > successfullCustomers) {
				successfullCustomers = state.successfulCustomers;
				optimalCheckOutAmount = state.totalCheckouts;
			}
			if (state.totalCheckouts == state.maxCustomers) {
				break;
			}
			if (state.missedCustomers == 0) {
				break;
			}
			checkOuts++;

			
		}
		return optimalCheckOutAmount;
		
	}
	private int method3(int seed) {
		int greatestSmallestAmountOfCheckouts = 0;
		int didntChange = 0;
		Random rand = new Random(seed);
		while(true) {
		
			int smallestAmountOfCheckouts = method2(rand.nextInt());
			
			if (smallestAmountOfCheckouts > greatestSmallestAmountOfCheckouts) {
				greatestSmallestAmountOfCheckouts = smallestAmountOfCheckouts;
				didntChange = 0;
			}
			else {
				didntChange++;
			}
			if (didntChange == 100) {
				break;
			}
		}
		
		return greatestSmallestAmountOfCheckouts;
		
		
	}
}
