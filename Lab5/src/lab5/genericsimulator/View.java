package lab5.genericsimulator;


import lab5.shopsimulator.ShopState;
import lab5.shopsimulator.shopevents.ShopEvent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class View implements Observer{

	private Simulator sim;
	private State state;
	private ShopState shopState;
	private ArrayList<String> stringArr = new ArrayList<String>();
	private Event event;
	private ShopEvent shopEvent;
	private int lastId;
	private String openString;

	public View (Simulator simulator) {
		sim = simulator;
		simulator.addObserver(this);
	}



	public String lineBuilder(String tid, String event, String kund, String status, String led, String ledT, String currentCustomers,

								String cashOuts, String sadCustomers, String customersQued, String queTime, String k�ar, String queSize ){
		return (tid +"   "+ event +"   "+ kund +"   "+ status +"   "+ led +"   "+ ledT +"   "+ currentCustomers +"   "+ cashOuts
				+"   "+ sadCustomers +"   "+ customersQued +"   "+ queTime +"   "+ k�ar +"   "+ queSize );
	}

	public String headLine(){
		return "PARAMETRAR \n " +
				"========== \n " +
		"Antal kassor, N..........:"+ ((ShopState) state).totCheckouts + "\n"  +
		"Max som ryms, M..........:" + ((ShopState) state).maxCustomers + "\n" +
		"Ankomshastighet, lambda..:" + ((ShopState) state).expRNG.lambda + "\n" +
		"Plocktider, [P_min..Pmax]:" + "[0.5...1.0]" + "\n" +
		"Betaltider, [K_min..Kmax]:" + "[2.0...3.0]" + "\n" +
		"Fr�, f...................:"+ ((ShopState) state).uniRNG.seed + "\n" +
		"F�RLOPP \n" +
				"==========";
	}
	public String endLine(){
		return "RESULTAT\n" + 
				"========\n" + 
				"1) Av " + 0 + " kunder handlade " +
				shopState.successfulCustomers + " medan " + shopState.customersLeft + " missades.\n" + 
				"2) Total tid 2 kassor varit lediga: 6,11 te.\n" + 
				" Genomsnittlig ledig kassatid: 3,06 te (dvs 23,03% av tiden fr�n �ppning tills sista kunden\n" + 
				"betalat).\n" + 
				"3) Total tid 5 kunder tvingats k�a: 13,60 te.\n" + 
				" Genomsnittlig k�tid: 2,72 te.";
	}



	public void update(Observable arg0, Object arg1) {
		state = sim.getState();
		shopState = ((ShopState) state);
		
		if(!shopState.getRunning()) {
			
			System.out.println(headLine());
			
			System.out.println("Tid   H�ndelse     Kund     ?     led     ledT     I     $     :-(     k�at     k�T     k�ar     [Kassak�..]   + \n"
					+ "0.00    Start");
			for(int i = 1; i < stringArr.size(); i++) {
				System.out.println(stringArr.get(i));
			}
			System.out.println("50.00   Stop");
			System.out.println(endLine());
	
		} else {
			DecimalFormat df = new DecimalFormat("0.00");
			df.setMaximumFractionDigits(2);
				event = sim.event;
				if(event instanceof ShopEvent) {
				shopEvent = (ShopEvent)event;
				lastId = shopEvent.customer.getID();
				if(shopState.canEnter) {
					openString = "�";
				} else {
					openString = "S";
				}
				stringArr.add(lineBuilder(String.format("%-5s", df.format(shopEvent.getTime())), String.format("%-10s",shopEvent.name()), String.format("%-3s",shopEvent.customer.getID()),
						String.format("%-5s",openString), String.format("%-5s",shopState.availableCheckouts),
						String.format("%-5s",shopState.checkoutsAvailableTotalTime), String.format("%-5s",shopState.currentCustomers),
						String.format("%-3s",shopState.successfulCustomers), String.format("%-5s",shopState.customersLeft),
						String.format("%-5s",shopState.peopleWhoHaveQueued), String.format("%-5s",df.format(shopState.totalQueuingTime)),
						String.format("%-5s",shopState.checkoutQueue.getSize()) , shopState.checkoutQueue.toString2()));
				} else {
					stringArr.add(lineBuilder(String.format("%-5s",df.format(event.getTime())), String.format("%-10s",event.name()), String.format("%-3s","---"),
							String.format("%-5s",openString), String.format("%-5s",shopState.availableCheckouts),
							String.format("%-5s",shopState.checkoutsAvailableTotalTime), String.format("%-5s",shopState.currentCustomers),
							String.format("%-3s",shopState.successfulCustomers), String.format("%-5s",shopState.customersLeft),
							String.format("%-5s",shopState.peopleWhoHaveQueued), String.format("%-5s",df.format(shopState.totalQueuingTime)),
							String.format("%-5s",shopState.checkoutQueue.getSize()) , shopState.checkoutQueue.toString2()));
				} 
				
			}
		}
}

