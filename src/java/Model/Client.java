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
public class Client extends Person{
    private Key key;
    
    public Client(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Client(String firstName, String lastName, String mail, int number, Key key) {
        super(firstName, lastName, mail, number);
        this.key = key;
    }

    

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
