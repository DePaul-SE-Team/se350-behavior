package org.example.Command.Light.Attempt;

public class Client {
    public static void main (String [] args){
        RemoteController remoteController = new RemoteController(new ConcreteLightOn());
        remoteController.pressButton();
        remoteController.setCommand(new ConcreteLightOff());
        remoteController.pressButton();
    }
}

interface Light{
    public void pressButton();
}

class ConcreteLightOn implements Light{
    public void pressButton(){
        System.out.println("turn on");
    }
}
class ConcreteLightOff implements Light{
    public void pressButton(){
        System.out.println("turn off");
    }
}


class RemoteController{
    private Light light;

    RemoteController(Light light){
        this.light = light;
    }

    public void setCommand(Light light){
        this.light = light;
    }

    public void pressButton(){
        this.light.pressButton();
    }
}
