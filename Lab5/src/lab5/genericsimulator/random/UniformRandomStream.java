
package lab5.genericsimulator.random;

import java.util.Random;


public class UniformRandomStream{

	private Random rand;
	public double lower,upper, width;
	public long seed;
	
	public UniformRandomStream(double lower, double upper, long seed) {
		rand = new Random(seed);
		this.lower = lower;
		this.upper = upper;
		this.width = upper-lower;
		this.seed = seed;
	}
	
	public UniformRandomStream(double lower, double upper) {
		rand = new Random();
	    this.lower = lower;
	    this.width = upper-lower;
	}
	
	public double next() {
	    return lower+rand.nextDouble()*width;
	}
}

