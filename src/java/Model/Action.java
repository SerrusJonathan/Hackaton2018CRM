/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    @OneToOne
    @JoinColumn(name ="staff_id")
    private Staff assignee;
    private String deadline;
    private String comment;
    @Enumerated(EnumType.STRING)
    private ActionStatus actionstatus;
    
    public Action(){
        
    }

    public Action(String text, Staff assignee, String deadline, String comment) {
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

    public Person getAssignee() {
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
