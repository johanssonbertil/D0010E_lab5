package lab5.genericsimulator;
import java.util.Observable;

import lab5.shopsimulator.ShopState;


public class Simulator extends Observable{
	private EventQueue queue;
	private State state;
	private View view;
	
	public Simulator(State state) {
		queue = new EventQueue(state);
		view = new View(this);
		
	}
	
	public void run() {
		while (state.getRunning()) {
			queue.nextEvent().doEvent();
			setChanged();
			notifyObservers();
		}
	}
}
