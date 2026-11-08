package org.example.Command.Light.Bad;

public class Client {
    public static void main (String [] args){
        RemoteController remoteController = new RemoteController(new Light());
        remoteController.pressButton(true);
        remoteController.pressButton(false);
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
    private Light light;

    RemoteController(Light light){
        this.light = light;
    }

    public void pressButton(boolean turnOn){
        if (turnOn){
            this.light.turnOn();
        }
        else{
            this.light.turnOff();
        }
    }
}
