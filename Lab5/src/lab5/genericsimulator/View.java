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
							String cashOuts, String sadCustomers, String customersQued, String queTime, String köar, String queSize ){
		return (tid +"   "+ event +"   "+ kund +"   "+ status +"   "+ led +"   "+ ledT +"   "+ currentCustomers +"   "+ cashOuts
				+"   "+ sadCustomers +"   "+ customersQued +"   "+ queTime +"   "+ köar +"   "+ queSize );
	}

	public String headLine(){
		return "PARAMETRAR \n" +
				"========== \n" +
		"Antal kassor, N..........:"+ shopState.totCheckouts + "\n"  +
		"Max som ryms, M..........:" + shopState.maxCustomers + "\n" +
		"Ankomshastighet, lambda..:" + shopState.expRNG.lambda + "\n" +
		"Plocktider, [P_min..Pmax]:" + "["+ shopState.uniPick.lower + ".." + shopState.uniPick.upper +"]" + "\n" +
		"Betaltider, [K_min..Kmax]:" + "["+ shopState.uniPay.lower + ".." + shopState.uniPay.upper +"]" + "\n" +
		"Frö, f...................:"+ shopState.uniRNG.seed + "\n" +
		"FÖRLOPP \n" +
				"==========";
	}
	public String endLine(){
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMaximumFractionDigits(2);
		return "RESULTAT\n" + 
				"========\n" + 
				"1) Av " + shopState.totalCustomers + " kunder handlade " +
				shopState.successfulCustomers + " medan " + shopState.customersLeft + " missades.\n" + 
				"2) Total tid 2 kassor varit lediga: "+ df.format(shopState.checkoutsAvailableTotalTime) +" te.\n" + 
				" Genomsnittlig ledig kassatid: "+ df.format(shopState.checkoutsAvailableTotalTime / shopState.totCheckouts)+" te (dvs "+ df.format(((shopState.checkoutsAvailableTotalTime / shopState.totCheckouts) / event.getTime()) * 100.00) + " % av tiden från öppning tills sista kunden\n" + 
				"betalat).\n" + 
				"3) Total tid "+ shopState.peopleWhoHaveQueued + " kunder tvingats köa: "+ df.format(shopState.totalQueuingTime) +  " te \n" + 
				" Genomsnittlig kötid: "+ df.format(shopState.totalQueuingTime / shopState.peopleWhoHaveQueued) +" te.";
	}



	public void update(Observable arg0, Object arg1) {
		state = sim.getState();
		shopState = ((ShopState) state);
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMaximumFractionDigits(2);
		
		if(!shopState.getRunning()) {
			
			System.out.println(headLine());
			
			System.out.println("Tid   Händelse     Kund     ?     led     ledT     I     $     :-(     köat     köT     köar     [Kassakö..]   + \n"
					+ "0.00    Start");
			for(int i = 1; i < stringArr.size(); i++) {
				System.out.println(stringArr.get(i));
			}
			System.out.println("999.00  Stop");
			System.out.println(endLine());
	
		} else {
			
				event = sim.event;
				if(event instanceof ShopEvent) {
				shopEvent = (ShopEvent)event;
				lastId = shopEvent.customer.getID();
				if(shopState.canEnter) {
					openString = "Ö";
				} else {
					openString = "S";
				}
				stringArr.add(lineBuilder(String.format("%-5s", df.format(shopEvent.getTime())), String.format("%-10s",shopEvent.name()), String.format("%-3s",shopEvent.customer.getID()),
						String.format("%-5s",openString), String.format("%-5s",shopState.availableCheckouts),
						String.format("%-5s",df.format(shopState.checkoutsAvailableTotalTime)), String.format("%-5s",shopState.currentCustomers),
						String.format("%-3s",shopState.successfulCustomers), String.format("%-5s",shopState.customersLeft),
						String.format("%-5s",shopState.peopleWhoHaveQueued), String.format("%-5s",df.format(shopState.totalQueuingTime)),
						String.format("%-5s",shopState.checkoutQueue.getSize()) , shopState.checkoutQueue.toString2()));
				} else {
					stringArr.add(lineBuilder(String.format("%-5s",df.format(event.getTime())), String.format("%-10s",event.name()), String.format("%-3s","---"),
							String.format("%-5s",openString), String.format("%-5s",shopState.availableCheckouts),
							String.format("%-5s",df.format(shopState.checkoutsAvailableTotalTime)), String.format("%-5s",shopState.currentCustomers),
							String.format("%-3s",shopState.successfulCustomers), String.format("%-5s",shopState.customersLeft),
							String.format("%-5s",shopState.peopleWhoHaveQueued), String.format("%-5s",df.format(shopState.totalQueuingTime)),
							String.format("%-5s",shopState.checkoutQueue.getSize()) , shopState.checkoutQueue.toString2()));
				} 
				
			}
		}
}

