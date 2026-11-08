package org.example.ChainOfResponsibility.Simple.Good.COR_Builder;

/**
 * current handle does the work and also pushes action to the net handler
 */
public class Client {
    public static void main (String [] args){
        HttpRequest request = new HttpRequest("SE350" ,"350");
        Validator validator = new Validator();
        Authentiator authentiator =  new Authentiator();
        Logger logger = new Logger();

        validator.setHandler(authentiator).setHandler(logger); // builder pattern
        WebServer webserver = new WebServer(validator);
        webserver.handle(request);

    }
}

class WebServer{
    Handler h;
    WebServer(Handler h){
        this.h = h;
    }
    public void handle(HttpRequest request){
        this.h.handle(request);
    }
}

class HttpRequest{
    private String username;
    private String password;
    private String validateUsername;
    private String validatePassword;

    HttpRequest(String username, String password){
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

abstract class Handler{
    Handler h;
    public Handler setHandler(Handler h){
        this.h = h;
        return h;
    }
    abstract void handle(HttpRequest request);
}

class Validator extends Handler{
    @Override
    void handle(HttpRequest request) {
        System.out.println("validate");
        var name = request.getUsername();
        var pass = request.getPassword();
        request.setValidatedUsername(name.trim());
        request.setValidatedPassword(pass.trim());
        super.h.handle(request);
    }
}

class Authentiator extends Handler{

    @Override
    void handle(HttpRequest request) {
        var name = request.getUsername();
        var pass = request.getPassword();
        if(name == "SE350" && pass == "350"){
            System.out.println("Authenticated");
            super.h.handle(request);
        }
    }
}

class Logger extends Handler{

    @Override
    void handle(HttpRequest request) {
        System.out.println("Logging request");
        System.out.println("End");
    }
}