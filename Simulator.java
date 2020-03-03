
public class Simulator {
	private EventQueue queue = new EventQueue();
	private State state;
	
	public Simulator(double lamda, long seed, int stopTime) {
		this.seed = seed;
		state = new State(lamda, seed);
		queue.add(new StopEvent(stopTime));
	}
	
	public void run() {
		while (State.running) {
			queue.nextEvent().doEvent();
		}
	}
}
