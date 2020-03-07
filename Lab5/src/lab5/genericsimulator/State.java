package lab5.genericsimulator;

import java.util.Observable;
import java.util.Observer;

import lab5.genericsimulator.random.*;



public abstract class State implements Observer {
    private double runningTime;
    public double maxTime;
    private boolean running;
    public ExponentialRandomStream expRNG;
    public UniformRandomStream uniRNG;

    public State(double maxT, ExponentialRandomStream exp, UniformRandomStream uni) {
    	runningTime = 0;
    	running = true;
    	maxTime = maxT;
    	expRNG = exp;
    	uniRNG = uni;
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

    @Override
    public void update(Observable o, Object arg) {

    }
    
}