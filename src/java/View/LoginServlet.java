/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonathan
 */
@WebServlet(name = "LoginMenuServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("uname");
        String password = request.getParameter("psw");
        
        String hiddenParam = request.getParameter("loginRegister");
        System.out.println(username + " " + password + " " + hiddenParam);
        
        switch (hiddenParam){
            case"register":
                try {
                    System.out.println("trying to register a new user...");
                    HackatonDB.getInstance().storeNewUser(username, password);
                } catch (SQLException e){
                    e.printStackTrace();
                }
                break;
            case "login":
                try {
                    System.out.println("trying to log in...");
                    if (HackatonDB.getInstance().loginUser(username, password)){
                        HttpSession session = request.getSession();
                        session.setAttribute("user", username);
                        
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("<p>Good job! User logged in with account: " + session.getAttribute("user") + "!</p>");
                    } else {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("<p>Username or password are incorrect, please try again ...</p>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
           
    }
    
}
