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
		int seed = 1234;
		ExponentialRandomStream expR = new ExponentialRandomStream(1, seed); // Skapar alla instanser av objekt som används
		UniformRandomStream uniR = new UniformRandomStream(0.5, 1.0, seed);
		ShopState state  = new ShopState(500, expR, uniR);
		Simulator sim = new Simulator(state);	
		sim.getEventQueue().add(new StartEvent(state, 0, sim.getEventQueue()));
		sim.getEventQueue().add(new ArrivalEvent(state, 1, sim.getEventQueue(), state.cFactory.getNextCustomer()));// Lägger till 3 events till eventQueue och kör sedan simulatorn
		sim.getEventQueue().add(new CloseEvent(state, 10, sim.getEventQueue()));
		sim.getEventQueue().add(new StopEvent(state, 50, sim.getEventQueue()));
		sim.run();
		
		
	}
	
	
}
