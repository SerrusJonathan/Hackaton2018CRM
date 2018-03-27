/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Hackaton2018;
import Controller.HackatonDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonathan
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws  ServletException, IOException {
        doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("uname");
        String password = request.getParameter("psw");
        
        String hiddenParam = request.getParameter("loginRegister");
        
        switch (hiddenParam){
            case"register":
                try {
                    HackatonDB.getInstance().storeNewUser(username, password);
                    
                    HttpSession session = request.getSession();
                    session.setAttribute("user", username);
                    
                    response.sendRedirect("Dashboard.jsp");
                    return;
                } catch (SQLException e){
                    e.printStackTrace();
                }
                break;
            case "login":
                try {
                    if (HackatonDB.getInstance().loginUser(username, password)){
                        HttpSession session = request.getSession();
                        session.setAttribute("user", username);
                        
                        response.sendRedirect("Dashboard.jsp");
                        return;
                      
                    } else {
                        response.sendRedirect("invalidLogin.html");
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
           
    }
    
}
