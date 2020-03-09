package lab5.genericsimulator;

import java.util.Observable;
import java.util.Observer;

import lab5.genericsimulator.random.*;



public abstract class State extends Observable {
    private double runningTime;
    public double maxTime;
    private boolean running;
    public ExponentialRandomStream expRNG;
    public UniformRandomStream uniRNG;
	public View view;
	public Event event;

    public State(double maxT, ExponentialRandomStream exp, UniformRandomStream uni1) {
    	runningTime = 0;
    	running = true;
    	maxTime = maxT;
    	expRNG = exp;
    	uniRNG = uni1;
    	view = new View(this);
    	this.addObserver(view);
    }
    
    
    public double getRunningTime(){
        return runningTime;
    }

    public boolean getRunning(){
        return running;
    }

    public void setRunning(boolean x){
        running = x;
    }
    public void updateObs(Event e) {
    	setChanged();
    	notifyObservers(e);
    }
   
}