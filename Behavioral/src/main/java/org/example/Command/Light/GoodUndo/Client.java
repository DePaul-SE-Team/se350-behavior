package org.example.Command.Light.GoodUndo;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main (String [] args){
        Light light = new Light();
        Command turnOffCommand = new turnOffCommand();
        Command turnOnCommand = new turnOnCommand();
        RemoteController controller = new RemoteController(turnOffCommand);
        controller.pressButton();
        controller.undo();
    }
}

interface Command{
    public void execute();
    public void undo();
}

class turnOnCommand implements Command{
    Light light;
    turnOnCommand(){
        this.light = new Light();
    }

    @Override
    public void execute() {
        this.light.turnOn();
    }

    @Override
    public void undo() {
        this.light.turnOff();
    }
}


class turnOffCommand implements Command{
    Light light;
    turnOffCommand(){
        this.light = new Light();
    }

    @Override
    public void execute() {
        this.light.turnOff();
    }

    @Override
    public void undo() {
        this.light.turnOn();
    }

}

class Light{
    public void turnOn(){
        System.out.println("turn on");
    }
    public void turnOff(){
        System.out.println("turn off");
    }
}

class RemoteController{
    private Command command;

    RemoteController(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }

    public void undo(){
        command.undo();
    }
}

