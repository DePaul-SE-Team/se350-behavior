package org.example.Template.Simple.Attempt_Strategy;

public class Client {
    public static void main (String [] args){
        MakeBeverage makeBeverage = new MakeBeverage(new Tea());
        makeBeverage.MakeBeverage();
    }
}

interface Beverage{
    public void brew();
    public void addCondiments();
}

class Tea implements Beverage{
    public void brew(){
        System.out.println("Steeping the tea");
    }
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }
}

class MakeBeverage{
    Beverage beverage;

    MakeBeverage(Beverage beverage){
        this.beverage = beverage;
    }

    public void BoilWater(){
        System.out.println("Boil Water");
    }
    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
    public void MakeBeverage(){
        BoilWater();
        this.beverage.brew();
        this.beverage.addCondiments();
        pourInCup();
    }
}

