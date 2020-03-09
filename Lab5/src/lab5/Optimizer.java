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
		method3(1234);
	}
	private ShopState method1(int checkouts, int seed) {
		
		
		ExponentialRandomStream expR = new ExponentialRandomStream(3.0, seed); // Skapar alla instanser av objekt som används
		UniformRandomStream uniPick = new UniformRandomStream(0.6, 0.9, seed);
		UniformRandomStream uniPay = new UniformRandomStream(0.35, 0.6, seed);
		ShopState state  = new ShopState(1000, expR, uniPick, uniPay, checkouts);
		Simulator sim = new Simulator(state);
		sim.getEventQueue().add(new StartEvent(state, 0, sim.getEventQueue()));
		sim.getEventQueue().add(new ArrivalEvent(state, state.expRNG.next(), sim.getEventQueue(), state.cFactory.getNextCustomer()));
		sim.getEventQueue().add(new CloseEvent(state, 8.0, sim.getEventQueue()));
		sim.getEventQueue().add(new StopEvent(state, 999, sim.getEventQueue()));
		sim.run();
		
		return state;
	}
	
	private int method2(int seed) {
		int missedCustomers = 1;
		ShopState state;
		int checkOuts = 0;
		while (missedCustomers > 0) {
			checkOuts++;
			state = method1(checkOuts, seed);
			missedCustomers = state.missedCustomers; 
		}
		return checkOuts;
		
	}
	private int method3(int seed) {
		int greatestSmallestAmountOfCheckouts = 0;
		int didntChange = 0;
		Random rand = new Random(seed);
		while(true) {
		
			int smallestAmountOfCheckouts = method2(rand.nextInt());
			if (smallestAmountOfCheckouts > greatestSmallestAmountOfCheckouts) {
				greatestSmallestAmountOfCheckouts = smallestAmountOfCheckouts;
			}
			else if (smallestAmountOfCheckouts == greatestSmallestAmountOfCheckouts) {
				didntChange++;
			}
			if (didntChange == 4) {
				break;
			}
		}
		
		return greatestSmallestAmountOfCheckouts;
		
		
	}
}
