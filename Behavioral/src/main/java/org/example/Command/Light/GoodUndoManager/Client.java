package org.example.Command.Light.GoodUndoManager;

import java.util.Stack;

public class Client {
    public static void main (String [] args){
        Light light = new Light();
        Command turnOffCommand = new turnOffCommand();
        Command turnOnCommand = new turnOnCommand();
//        RemoteController controller = new RemoteController(turnOffCommand);
//        controller.pressButton();
//        controller = new RemoteController(turnOnCommand);
//        controller.pressButton();

        // test 1
//        RemoteController controller = new RemoteController();
//        controller.pressButton(turnOnCommand);
//        controller.pressButton(turnOffCommand);
//        controller.undoButtonPress();
//        controller.redoButtonPress();
//        controller.undoButtonPress(); // on off on off on
//        controller.undoButtonPress(); // off
//        controller.undoButtonPress();

        // test 2
//        RemoteController controller = new RemoteController();
//        controller.pressButton(turnOnCommand);
//        controller.pressButton(turnOffCommand);
//        controller.undoButtonPress();
//        controller.redoButtonPress();
//        controller.undoButtonPress(); // on off on off on
//        controller.undoButtonPress(); // off
//        controller.pressButton(turnOnCommand); // on
//        controller.undoButtonPress(); // off

        // test3
        RemoteController controller = new RemoteController();
        controller.pressButton(turnOnCommand);
        controller.pressButton(turnOffCommand);
        controller.undoButtonPress();
        controller.redoButtonPress();
        controller.undoButtonPress(); // on off on off on
        controller.pressButton(turnOnCommand); // on
        controller.undoButtonPress(); // off
        controller.undoButtonPress(); // off

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
    Stack<Command> undos = new Stack<>();
    Stack<Command> redos = new Stack<>();

//    private Command command;
//
//    RemoteController(Command command){
//        this.command = command;
//    }
//    public void pressButton(){
//        command.execute();
//    }

    public Object pressButton(Command command){
        command.execute();
        undos.push(command);
//        redos.clear();
        return "turn on";
    }

    public void undoButtonPress(){
        if (!undos.isEmpty()){
            Command c = undos.pop();
            c.undo();
            redos.push(c);
        }
    }

    public void redoButtonPress(){
        if (!redos.isEmpty()){
            Command c = redos.pop();
            c.execute();
            undos.push(c);
        }
    }
}

