package org.example.Template.Simple.Attempt_Inheritance;

public class Client {
    public static void main (String [] args){
        var Tea = new Tea();
        Tea.makeBeverage();
    }
}

abstract class Beverage{
    public void BoilWater(){
        System.out.println("Boil Water");
    }
    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

    public void makeBeverage(){
        BoilWater();
        brew();
        addCondiments();
        pourInCup();
    }

    abstract void brew();
    abstract void addCondiments();
}

class Tea extends Beverage{

    public void brew(){
        System.out.println("steep tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}


