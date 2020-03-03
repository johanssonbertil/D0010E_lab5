import java.util.Observable;
import java.util.Observer;

public abstract class State implements Observer {
    private int runningTime;
    private boolean running;

    public State(double lamba, double seed) {
    	
    }
    
    
    public int getRunningTime(){
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
