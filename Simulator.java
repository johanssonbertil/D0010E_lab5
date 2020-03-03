
public class Simulator {
	private EventQueue queue;
	private State state;
	
	public Simulator(double lamda, long seed, int stopTime) {
		state = new ShopState(lamda, seed);
		queue = new EventQueue(state);
		queue.add(new StopEvent(state, stopTime, queue));
	}
	
	public void run() {
		while (state.getRunning()) {
			queue.nextEvent().doEvent();
		}
	}
}
