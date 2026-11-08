package org.example.Template.Simple.Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Client {
    /**
     * Refactor this class to use template method pattern
     * Remember the steps:
     * 1. Analyze the existing algorithm... Find if the algorithm has steps. If it does, then find what is common and unique for different subclass
     * 2. Create abstract class and define template method with steps. Some steps will be common and other will be unique.
     * 3. Consider making template method final to prevent subclass from overriding
     * 4. For each variation of algorithm, add subclass, and implement the abstract method
     *
     * After you try it on your own you can check with the solution.
     */
    public static void main (String [] args){
        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        tea.prepareRecipe();
        System.out.println();
        coffee.prepareRecipe();

    }
}

class Tea {
    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    public void boilWater() {
        System.out.println("Boiling water");
    }

    public void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    public void addLemon() {
        System.out.println("Adding Lemon");
    }

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

class Coffee {
    void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    public void boilWater() {
        System.out.println("Boiling water");
    }

    public void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee through filter");
    }

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

    public void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }
}