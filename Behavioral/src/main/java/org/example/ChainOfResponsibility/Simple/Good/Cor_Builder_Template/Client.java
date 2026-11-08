package org.example.ChainOfResponsibility.Simple.Good.Cor_Builder_Template;
/**
 * current handle does the work and also pushes action to the net handler.
 * Thus, here we use template pattern in order to reuse method (calling next handler) and allow subclasses do the actual work
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
        this.h.templateHandle(request);
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
        return this.h;
    }
    public void templateHandle(HttpRequest request){
        if (handle(request)){
            if (this.h != null){
                this.h.templateHandle(request);
            }
        }
    }
    abstract boolean handle(HttpRequest request);
}

class Validator extends Handler{
    @Override
    boolean handle(HttpRequest request) {
        System.out.println("validate");
        var name = request.getUsername();
        var pass = request.getPassword();
        request.setValidatedUsername(name.trim());
        request.setValidatedPassword(pass.trim());
        return true;
    }
}

class Authentiator extends Handler {

    @Override
    boolean handle(HttpRequest request) {
        System.out.println("Authenticate");
        var name = request.getUsername();
        var pass = request.getPassword();
        return (name == "SE350" && pass == "350");
    }
}

class Logger extends Handler {
    @Override
    boolean handle(HttpRequest request) {
        System.out.println("Logging request");
        System.out.println("End");
        return false;
    }
}