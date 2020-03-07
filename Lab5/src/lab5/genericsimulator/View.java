package lab5.genericsimulator;


import lab5.shopsimulator.ShopState;

import java.util.Observable;
import java.util.Observer;


public class View implements Observer{

	private Simulator sim;
	private State state;
	private ShopState shopState;

	public View (Simulator simulator) {
		sim = simulator;
		simulator.addObserver(this);
	}



	public String lineBuilder(double tid, String event, int kund, boolean status, int led, double ledT, int currentCustomers,

								int cashOuts, int sadCustomers, int customersQued, double queTime, int köar, String queSize ){
		return (tid +" "+ event +" "+ kund +" "+ status +" "+ led +" "+ ledT +" "+ currentCustomers +" "+ cashOuts
				+" "+ sadCustomers +" "+ customersQued +" "+ queTime +" "+ köar +" "+ queSize );
	}

	public String headLine(){
		return "PARAMETRAR \n " +
				"========== \n " +
		"Antal kassor, N..........:"+ ((ShopState) state).totCheckouts + "\n"  +
		"Max som ryms, M..........:" + ((ShopState) state).maxCustomers + "\n" +
		"Ankomshastighet, lambda..:" + ((ShopState) state).expRNG.lambda + "\n" +
		"Plocktider, [P_min..Pmax]:" + "[" + ((ShopState) state).uniRNG.lower + ".." + ((ShopState) state).uniRNG.upper + "]" + "\n" +
		"Betaltider, [K_min..Kmax]:" + "[" + ((ShopState) state).uniRNG.lower + ".." + ((ShopState) state).uniRNG.upper + "]" + "\n" +
		"Frö, f...................:"+ ((ShopState) state).uniRNG.seed + "\n" +
		"FÖRLOPP \n" +
				"==========";
	}



	public void update(Observable arg0, Object arg1) {
		state = sim.getState();
		shopState = ((ShopState) state);
		System.out.println(headLine());
		for(int i = 0; i < sim.getEventQueue().getArr().size(); i++) {
			System.out.println(lineBuilder(sim.getEventQueue().getArr().get(i).getTime(), sim.getEventQueue().nextEvent().name(), shopState.cFactory.getNextCustomer().getID(),
					shopState.canEnter, 0, 0, shopState.currentCustomers, shopState.successfulCustomers, shopState.customersLeft,
					shopState.peopleWhoHaveQueued, shopState.totalQueuingTime , shopState.checkoutQueue.getSize() , shopState.checkoutQueue.toString2()));
		}
	}



}
