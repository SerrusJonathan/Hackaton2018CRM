package Model;




import java.util.List;
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
public class Meeting {
   @Id
   @GeneratedValue
    private long id;
    private String title;
    private String date;
    private String place;
    @OneToOne
    @JoinColumn(name="client_id")
    private Client client;
    @OneToOne
    @JoinColumn(name="staff_id")
    private Staff staff;
    @OneToOne
    @JoinColumn(name="topics_id")
    private Topics topics;
    @OneToOne
    @JoinColumn(name="action_id")
    private Action action;

    public Meeting() {
    }

    
    
    public Meeting(String title, String date, String place, Action action, Client client, Topics topics) {
        this.title = title;
        this.date = date;
        this.place = place;
        this.action = action;
        this.client = client;
        this.topics = topics;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }
    
    public Client getClient(){
        return client;
    }

    public Staff getStaff() {
        return staff;
    }

    public Topics getTopics() {
        return topics;
    }

    public Action getAction() {
        return action;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setTopics(Topics topic) {
        this.topics = topics;
    }
    
    
    
}
