package lab5.genericsimulator;

import java.util.ArrayList;

public class EventQueue {

	private ArrayList<Event> eventArr;
	
	
	public EventQueue(State state){
		 eventArr = new ArrayList<Event>();
	}	
	
	public Event nextEvent() {
		Event next = eventArr.get(0); 
		eventArr.remove(0);
		return next;
	}
	public ArrayList<Event> getArr(){
		return eventArr;
	}
	
	public void add(Event e) {
		if(eventArr.size() == 0) {
			eventArr.add(e);
		} else {
			for(int i = 0; i < eventArr.size(); i++) {
				if(eventArr.get(i).getTime() > e.getTime()) {
					eventArr.add(i, e);
					break;
				}
				else if(i == eventArr.size() - 1) {
					eventArr.add(e);
					break;
				}
			}
		}
		
	}
	
	public void remove(Event e) {
		eventArr.remove(e);
	}
}