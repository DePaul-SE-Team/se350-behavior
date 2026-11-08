package org.example.ChainOfResponsibility.Simple.Bad;

public class Client {
    public static void main (String [] args){
        WebServer server = new WebServer();
        server.Handle(new HTTPRequest("SE350", "350"));
    }
}

class WebServer{
    public void Handle(HTTPRequest request){
        var validator = new Validator(request);

        var authenticator = new Authenticator();
        authenticator.Authenticate(request);

        var Logger = new Logger();
        Logger.Log(request);

    }
}

class HTTPRequest{
    private String username;
    private String password;
    private String validateUsername;
    private String validatePassword;

    HTTPRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

    String getUsername(){
        return this.username;
    }

    String getPassword(){
        return this.password;
    }

    void setValidatedUsername(String username){
        this.validateUsername = username;
    }
    void setValidatedPassword(String password){
        this.validatePassword = password;
    }
}

class Validator{

    Validator(HTTPRequest request){
        var name = request.getUsername();
        var pass = request.getPassword();
        request.setValidatedUsername(name.trim());
        request.setValidatedPassword(pass.trim());
    }
}

class Authenticator{
    boolean Authenticate(HTTPRequest request){
        var name = request.getUsername();
        var pass = request.getPassword();
        return name == "SE350" && pass == "350";
    }
}

class Logger{
    void Log(HTTPRequest request){
        System.out.println("Logging request");
    }

}