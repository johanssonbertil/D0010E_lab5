package lab5;

import java.util.Random;

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
		Optimizer optimizer = new Optimizer();
		optimizer.run();
		
		
	}
	
	
	
}
