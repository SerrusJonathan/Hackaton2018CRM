/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Jonathan
 */
public class Action {
    
    private String text;
    private Person assignee;
    private String deadline;
    private String comment;
    private ActionStatus actionstatus;
    

    public Action(String text, Person assignee, String deadline, String comment) {
        this.text = text;
        this.assignee = assignee;
        this.deadline = deadline;
        this.comment = comment;
        this.actionstatus = ActionStatus.Open;
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
