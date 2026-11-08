package org.example.Observer.Simple.GoodPush;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main (String [] args){
        DataSource data = new DataSource();
//        data.addData(4); // if you call this before adding observer it does not work
        data.addObserver(new Sheet2());
        data.addObserver(new BarChart());
        data.addData(4);
        data.addData(5);
    }
}

// Observerable -> manages observer
abstract class Subject{
    // it's only purpose is to manage
    List<Observer> dependents = new ArrayList<>();
    public void addObserver(Observer o){
        dependents.add(o);
    }
    public void removeObserver(Observer o){
        dependents.remove(o);
    }
    public void notifyObservers(List<Integer> value){
        for (var o : dependents){
            o.update(value);
        }
    }
}

class DataSource extends Subject{
    List<Integer> Data = new ArrayList<>();
    public void addData(Integer i){
        Data.add(i);
        notifyObservers(Data);
    }
}

interface Observer{
    public void update(List<Integer> value);
}

class Sheet2 implements Observer{
    public void update(List<Integer> value) {
        System.out.println("Update sheet");
        calculateTotal(value);
    }
    public void calculateTotal(List<Integer> value){
        int sum = 0;
        for(var d : value){
            sum += d;
        }
        System.out.println("New Total: "+sum);
        System.out.println("Render sheet with new data");
        System.out.println();
    }
}

class BarChart implements Observer{
    @Override
    public void update(List<Integer> value) {
        System.out.println("Update Barchart");
        Render( value);
    }

    public void Render(List<Integer> value){
        System.out.println("New Data Point: "+value);
        System.out.println("Render bar chart with new data");
        System.out.println();
    }
}