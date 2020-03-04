package lab5.shopsimulator;


import lab5.shopsimulator.customer.Customer;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO {
    private ArrayList<Customer> fifoLst = new ArrayList<>();


    public void add(Customer x){
        this.fifoLst.add(x);
    }

    public Customer nextCustomer(){
        Customer tempCustomer;
        if (!isEmpty()){
            tempCustomer = fifoLst.get(0);
            fifoLst.remove(0);
            return tempCustomer;
        }
        return null;
    }

    public void removeFirst() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        fifoLst.remove(0);
    }

    public Customer first() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return fifoLst.get(0);
    }


    public boolean isEmpty(){
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

