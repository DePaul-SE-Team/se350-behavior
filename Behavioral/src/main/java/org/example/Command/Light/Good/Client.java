package org.example.Command.Light.Good;

public class Client {
    public static void main (String [] args){
        Light light = new Light();
        Command turnOffCommand = new turnOffCommand(light);
        Command turnOnCommand = new turnOnCommand(light);
        RemoteController controller = new RemoteController(turnOffCommand);
        controller.pressButton();

        controller = new RemoteController(turnOnCommand);
        controller.pressButton();
    }
}

interface Command{
    public void execute();
}

class turnOnCommand implements Command{
    Light light;
    turnOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.turnOn();
    }
}


class turnOffCommand implements Command{
    Light light;
    turnOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.turnOff();
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
}


