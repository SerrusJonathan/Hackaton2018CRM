/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jonathan
 */
@WebServlet(name = "meetingServlet", urlPatterns = {"/meetingServlet"})
public class meetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("clients", HackatonDB.getInstance().getAllClients());
            request.setAttribute("staff", HackatonDB.getInstance().getAllStaff());
        } catch (SQLException ex) {
            Logger.getLogger(meetingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dis = getServletContext().getRequestDispatcher("addMeeting.jsp");
        if(dis != null)
          dis.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String date = request.getParameter("date");
        String place = request.getParameter("place");
        String clientName = request.getParameter("client");
        String staffName = request.getParameter("staff");
        String topicName = request.getParameter("topicTitle");
        String topicComment = request.getParameter("topicComments");
        String actionText = request.getParameter("textAction");
        String staffAction = request.getParameter("staffAction");
        String[] splited = staffAction.split("\\s+");
        String deadlineDate = request.getParameter("deadlineDate");
        String titleAction = request.getParameter("titleAction");
        
        HackatonDB.getInstance().storeMeeting(new Meeting(title, date, place, new Action(titleAction, new Staff(splited[1], splited[0]), deadlineDate, actionText), new Client(clientName, staffName), new Topics(topicName, topicComment)));
    }
}
