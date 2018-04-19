package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jonathan
 */
@Entity
public class Topics {
    
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;

    public Topics(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Topics() {
        
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    
}
