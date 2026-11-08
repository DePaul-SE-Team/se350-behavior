package org.example.Observer.Simple.GoodPull;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main (String [] args){
        DataSource data = new DataSource();
//        data.addData(4); // if you call this before adding observer it does not work
        data.addObserver(new Sheet2(data));
        data.addObserver(new BarChart(data));
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
    public void notifyObservers(){
        for (var o : dependents){
            o.update();
        }
    }
}

class DataSource extends Subject{
    List<Integer> Data = new ArrayList<>();
    public void addData(Integer i){
        Data.add(i);
        notifyObservers();
    }

    public List<Integer> getDataSource(){
        return this.Data;
    }
}

interface Observer{
    public void update();
}

class Sheet2 implements Observer{
    DataSource data;
    Sheet2(DataSource data){
        this.data = data;
    }
    @Override
    public void update() {
        System.out.println("Update sheet");
        calculateTotal();
    }
    public void calculateTotal(){
        int sum = 0;
        for(var d : this.data.getDataSource()){
            sum += d;
        }
        System.out.println("New Total: "+sum);
        System.out.println("Render sheet with new data");
        System.out.println();
    }
}

class BarChart implements Observer{
    DataSource data;
    BarChart(DataSource data){
        this.data = data;
    }
    @Override
    public void update() {
        System.out.println("Update Barchart");
        Render();
    }

    public void Render(){
        System.out.println("New Data Point: "+data.getDataSource());
        System.out.println("Render bar chart with new data");
        System.out.println();
    }
}