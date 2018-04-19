package Model;

import javax.persistence.Entity;

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
public class Staff extends Person{
    
    public Staff(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Staff() {
    }
    
    
}
