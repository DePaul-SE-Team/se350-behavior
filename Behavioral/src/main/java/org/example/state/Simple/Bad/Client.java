package org.example.state.Simple.Bad;

public class Client {
    public static void main (String [] args){
        Document document = new Document();
        document.setState(BlogState.UnderReview);
        document.setUserRole(UserRole.Admin);
        System.out.println(document.getState());
        document.publish();
        System.out.println(document.getState());
    }
}
/**
 * Requirement: Let’s say you are an influencer,
 * and you are writing a blog post using a popular content management system (Wix or Canva).
 * The blog post can exist in three states: (i) Draft, (ii) UnderReview (By admin) and (iii) Published
 *
 * Based on these states you can have three different kind of user roles that act on the blog:
 * (i) Reader (ii) Editor (iii) Admin
 */

enum BlogState{
    Draft,
    UnderReview,
    Published
}

enum UserRole{
    Reader, Editor, Admin
}

class Document{
    BlogState state;
    UserRole role;
    public void setState(BlogState state){
        this.state = state;
    }
    public void setUserRole(UserRole role){
        this.state = BlogState.Published;
        this.role = role;
    }
    public BlogState getState(){
        return this.state;
    }
    public void publish(){
        if (this.state == BlogState.Draft){
            this.state = BlogState.UnderReview;
        }
        else if (this.state == BlogState.UnderReview){
            if (this.role == UserRole.Admin){

            }
        }
        else if (this.state == BlogState.Published){
            // do nothing... as it is already published
        }
    }
}
