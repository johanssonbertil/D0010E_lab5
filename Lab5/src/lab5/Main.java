package lab5;

import lab5.genericsimulator.Simulator;
import lab5.genericsimulator.StartEvent;
import lab5.genericsimulator.State;
import lab5.genericsimulator.StopEvent;
import lab5.genericsimulator.View;
import lab5.genericsimulator.random.ExponentialRandomStream;
import lab5.genericsimulator.random.UniformRandomStream;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.shopevents.ArrivalEvent;
import lab5.shopsimulator.shopevents.CloseEvent;

public class Main {

	public static void main(String[] args) {
		method1();
		
		
	}
	
	private static void method1() {
		
		int seed = 1234;
		ExponentialRandomStream expR = new ExponentialRandomStream(1, seed); // Skapar alla instanser av objekt som används
		UniformRandomStream uniPick = new UniformRandomStream(0.5, 1.0, seed);
		UniformRandomStream uniPay = new UniformRandomStream(2.0, 3.0, seed);
		ShopState state  = new ShopState(1000, expR, uniPick, uniPay);
		Simulator sim = new Simulator(state);
		sim.getEventQueue().add(new StartEvent(state, 0, sim.getEventQueue()));
		sim.getEventQueue().add(new ArrivalEvent(state, state.expRNG.next(), sim.getEventQueue(), state.cFactory.getNextCustomer()));
		sim.getEventQueue().add(new CloseEvent(state, 10.0, sim.getEventQueue()));
		sim.getEventQueue().add(new StopEvent(state, 999, sim.getEventQueue()));
		sim.run();
		
	}
	
	
}
