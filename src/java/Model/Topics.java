package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jonathan
 */
public class Topics {
    
    private String title;
    private String content;

    public Topics(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Topics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    
}
