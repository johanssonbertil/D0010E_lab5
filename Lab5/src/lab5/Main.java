package lab5;

import lab5.genericsimulator.Simulator;
import lab5.genericsimulator.StartEvent;
import lab5.genericsimulator.State;
import lab5.genericsimulator.StopEvent;
import lab5.genericsimulator.View;
import lab5.genericsimulator.random.ExponentialRandomStream;
import lab5.genericsimulator.random.UniformRandomStream;
import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.shopevents.CloseEvent;

public class Main {

	public static void main(String[] args) {
		
		ExponentialRandomStream expR = new ExponentialRandomStream(0); // Skapar alla instanser av objekt som används
		UniformRandomStream uniR = new UniformRandomStream(0, 100);
		State state  = new ShopState(2000, expR, uniR);
		Simulator sim = new Simulator(state);
		
		sim.getEventQueue().add(new StartEvent(state, 10, sim.getEventQueue())); // Lägger till 3 events till eventQueue och kör sedan simulatorn
		sim.getEventQueue().add(new CloseEvent(state, 100, sim.getEventQueue()));
		sim.getEventQueue().add(new StopEvent(state, 1000, sim.getEventQueue()));
		sim.run();
		
		
	}
	
	
}
