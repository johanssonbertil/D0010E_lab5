package lab5.genericsimulator;


import java.util.Observable;
import java.util.Observer;

public class View implements Observer{

	public View (Simulator simulator) {
		simulator.addObserver(this);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.print("Place Holder");
		
	}
	
}
