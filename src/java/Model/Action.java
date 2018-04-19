/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jonathan
 */
@Entity
public class Action {
    
    @Id
    @GeneratedValue
    private long id;
    private String text;
    @ManyToMany
    @JoinTable(name = "action_assignee",
            joinColumns = @JoinColumn(name = "action_id"),
            inverseJoinColumn = @JoinColumn(name = "PAUL"))
    private List<Staff> assignee;
    private String deadline;
    private String comment;
    @Enumerated(EnumType.STRING)
    private ActionStatus actionstatus;
    
    public Action(){
        
    }

    public Action(String text, List<Staff> assignee, String deadline, String comment) {
        this.text = text;
        this.assignee = assignee;
        this.deadline = deadline;
        this.comment = comment;
        this.actionstatus = ActionStatus.Open;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Staff> getAssignee() {
        return assignee;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getComment() {
        return comment;
    }

    public ActionStatus getActionstatus() {
        return actionstatus;
    }
    
    public void setActionStatusClosed(){
        this.actionstatus = ActionStatus.Closed;
    }
    
    public void setActionStatusPending(){
        this.actionstatus = ActionStatus.Pending;
    }
    
    public void setActionStatusCancelled(){
        this.actionstatus = ActionStatus.Cancelled;
    }
    
}
