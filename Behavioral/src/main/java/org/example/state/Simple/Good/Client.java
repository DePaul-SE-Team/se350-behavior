package org.example.state.Simple.Good;

public class Client {
    public static void main (String [] args){
        Document document = new Document();
        document.setUserRole(UserRole.Reader);
        document.printState();
        document.publish();
        document.printState();
        document.publish();
        document.printState();
    }
}

enum UserRole{
    Reader, Editor, Admin
}

class Document{
    private State state;
    private UserRole role;

    Document(){
        this.state = new Draft(this);
    }
    public void setUserRole(UserRole userRole){
        this.role = userRole;
    }
    public void setState(State state){
        this.state = state;
    }

    public UserRole getUserRole(){
        return this.role;
    }

    public State getState(){
        return this.state;
    }

    public void publish(){
        this.state.publish();
    }
    public void printState(){
        System.out.printf("State: %s, Role: %s%n",this.state.getClass(), this.role);
    }
}

interface State{
    public void publish();
}

class Draft implements State{
    Document document;
    UserRole role;
    Draft(Document document){
        this.document = document;
    }
    @Override
    public void publish() {
        // after you do something in the logic
        this.document.setState(new UnderReview(this.document));
    }
}

class UnderReview implements State{
    Document document;
    UnderReview(Document document){
        this.document = document;
    }
    @Override
    public void publish() {
        if (this.document.getUserRole() == UserRole.Editor){
            // do something to review then transition
            this.document.setState(new Published(this.document));
            this.document.setUserRole(UserRole.Admin);
        }
    }
}

class Published implements State{
    Document document;
    Published (Document document){
        this.document = document;
    }
    @Override
    public void publish() {
        // do nothing
    }
}