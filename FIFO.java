
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO {
    private ArrayList<Integer> fifoLst = new ArrayList<>();


    public void add(int x){
        this.fifoLst.add(x);
    }

    public void removeFirst() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        fifoLst.remove(0);
    }

    public int first() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return fifoLst.get(0);
    }


    private boolean isEmpty(){
        return fifoLst.size() == 0;
    }

    public int getSize(){
        return fifoLst.size();
    }

    public String toString(){
        StringBuilder stringToBuild = new StringBuilder("Queue: ");
        for(Object x : this.fifoLst){
            if (x == null){
                stringToBuild.append("(").append("null").append(") ");
            }
            else{
                stringToBuild.append("(").append(x.toString()).append(") ");
            }
        }
        return stringToBuild.toString();
    }
}
