package Model;

import javax.persistence.*;

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
@Table(name = "client_key")
public class Key {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;

    public Key() {
    }

    
    public Key(String title, String content) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
