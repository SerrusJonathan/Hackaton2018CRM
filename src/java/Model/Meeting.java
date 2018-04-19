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
    @ManyToMany
    @JoinTable(name = "meeting_staff",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumn = @JoinColumn(name = "staff_id"))
    private List<Staff> staff;
    @ManyToMany
    @JoinTable(name = "meeting_topics",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumn = @JoinColumn(name = "topic_id"))
    private List<Topics> topics;
    @OneToMany
    @JoinTable(name = "meeting_actions",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumn = @JoinColumn(name = "action_id"))
    private List<Action> action;

    public Meeting() {
    }

    
    
    public Meeting(String title, String date, String place, List<Action> action, Client client, List<Topics> topics, List<Staff> staff) {
        this.title = title;
        this.date = date;
        this.place = place;
        this.action = action;
        this.client = client;
        this.topics = topics;
        this.staff = staff;
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

    public List<Staff> getStaff() {
        return staff;
    }

    public List<Topics> getTopics() {
        return topics;
    }

    public List<Action> getAction() {
        return action;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    public void setTopics(List<Topics> topic) {
        this.topics = topics;
    }
    
    
    
}
