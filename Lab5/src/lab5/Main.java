package lab5;

import lab5.genericsimulator.Simulator;
import lab5.genericsimulator.State;
import lab5.shopsimulator.ShopState;

public class Main {

	public static void main(String[] args) {
		State s  = new ShopState(10, null, null);
		Simulator sim = new Simulator(s);
		
		
	}
	
	
}
