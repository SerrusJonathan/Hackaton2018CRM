package Model;




import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class Meeting {
    
    private String title;
    private String date;
    private String place;
    private List<Staff> staff;
    private List<Topics> topics;

    public Meeting(String title, String date, String place) {
        this.title = title;
        this.date = date;
        this.place = place;
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

    public List<Staff> getStaff() {
        return staff;
    }

    public List<Topics> getTopics() {
        return topics;
    }
    
    
}
