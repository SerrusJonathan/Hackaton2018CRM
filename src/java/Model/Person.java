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
public class Person {
    
    private String firstName;
    private String lastName;
    public String mail;
    public int number;
    public String comment;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String mail, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public int getNumber() {
        return number;
    }

    public String getComment() {
        return comment;
    }
    
    public void setNumber(int number){
        this.number = number;
    }
    
    public void setEmail(String mail){
        this.mail = mail;
    }
    
    
    
}
