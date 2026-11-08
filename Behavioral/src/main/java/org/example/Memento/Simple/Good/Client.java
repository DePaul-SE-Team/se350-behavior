package org.example.Memento.Simple.Good;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main (String [] args){
        Editor editor = new Editor("title1","content1"); // current state: title1, content1
        History history = new History(editor);
        history.backup(); // saving title1, content1
        editor.print();   // print current state: title1, content1

        editor.setTitle("title2");
        editor.setContent("content2"); // current state: title2, content2
        editor.print();                // print current state: title2, content2

        history.restore();             // current state: title1, content1
        editor.print();                // print current state: title1, content1

    }
}


class Editor{
    private String content;
    private String title;

    Editor(String title, String content){
        this.title = title;
        this.content = content;
    }

    public EditorState createState(){
        return new EditorState(this.title, this.content);
    }
    public void restoreState(EditorState state){
        this.content = state.getPrevContent();
        this.title = state.getPrevTitle();
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void print(){
        System.out.println(String.format("Title: %s, Content: %s",this.title,this.content));
    }
}

/**
 * this is the Memento
 */
class EditorState{
    private final String prevContent;
    private final String prevTitle;
    EditorState(String prevTitle, String prevContent){
        this.prevContent = prevContent;
        this.prevTitle = prevTitle;
    }
    public String getPrevContent(){
        return this.prevContent;
    }
    public String getPrevTitle(){
        return this.prevTitle;
    }
}

/**
 * this is the caretaker
 */
class History{
    private Editor editor;
    private List<EditorState> states = new ArrayList<>();
    History(Editor editor){
        this.editor = editor;
    }
    public void backup(){
        states.add(editor.createState());
    }
    public void restore(){
        EditorState state = states.removeLast();
        editor.setContent(state.getPrevContent());
        editor.setTitle(state.getPrevTitle());
    }
}


