package org.example.Template.Simple.Solution;


public class Client {
    public static void main (String [] args){
        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        tea.prepareRecipe();
        System.out.println();
        coffee.prepareRecipe();

    }
}

abstract class CaffeineBeverage{
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (hook()){
            addCondiment();
        }
    }
    abstract void brew();
    abstract void addCondiment();
    public void boilWater() {
        System.out.println("Boiling water");
    }
    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
    public boolean hook(){
        return true;
    }
}
class Coffee extends CaffeineBeverage{
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }
    public void addCondiment() {
        System.out.println("Adding Sugar and Milk");
    }
    public boolean hook(){
        return false;
    }
}

class Tea extends CaffeineBeverage{
    public void brew() {
        System.out.println("Steeping the tea");
    }
    public void addCondiment() {
        System.out.println("Adding Lemon");
    }
}
