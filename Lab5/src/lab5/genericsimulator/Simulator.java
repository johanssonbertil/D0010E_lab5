package lab5.genericsimulator;
import java.io.IOException;
import java.util.Observable;

import lab5.shopsimulator.ShopState;


public class Simulator{
	private EventQueue queue;
	private State state;

	public Event event;
	
	public Simulator(State state) {
		this.state = state;
		queue = new EventQueue(state);		
	}
	public EventQueue getEventQueue() {
		return queue;
	}
	
	public void run() {
		while (state.getRunning()) {
			
			event = queue.nextEvent();
			
			event.doEvent();
		
		
					
		}

		
	}

	public State getState(){
		return state;
	}
}
