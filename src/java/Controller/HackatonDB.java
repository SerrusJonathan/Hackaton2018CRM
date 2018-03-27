package Controller;

import Model.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class  HackatonDB
{

    private static final String URL = "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2228988";
    private static final String UID = "sql2228988";
    private static final String PWD = "eD1!qD3*";
    
    private static HackatonDB instance;
    
    private Connection connection;
    
    private HackatonDB()
    {
        try
        {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, UID, PWD);
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public static HackatonDB getInstance()
    {
        if (instance == null)
        {
            instance = new HackatonDB();
        }
        return instance;
    }
    
    public void storeNewUser(String username, String password) throws SQLException{  
        String sql = "INSERT INTO CRM_Password(mail, password)" + " VALUES (?,?)";        
        PreparedStatement prep = this.connection.prepareStatement(sql);
        prep.setString(1, username);
        prep.setString(2, password);
        prep.executeUpdate();     
        prep.close();
    }
    
    public boolean loginUser(String username, String password) throws SQLException{
        String sql = "select * from CRM_Password where mail=?";
        PreparedStatement prep = this.connection.prepareStatement(sql);
        prep.setString(1, username);
        ResultSet rs = prep.executeQuery();
        if (rs.next()){
            String ControlePassword = rs.getString("password");
            if (ControlePassword.equals(password)){
                prep.close();
                return true;
            } else {
                prep.close();
                return false;
            }
        } else {
            prep.close();
            return false;
        } 
    }
    
    public ArrayList<Meeting> getAllMeetings(){
        ArrayList<Meeting> meetings = new ArrayList<>();
        String sql = "select * FROM CRM_Meetings";
        return meetings;
    }
    
    public ArrayList<Client> getAllClients() throws SQLException{
        ArrayList<Client> clients = new ArrayList<>();
        String sql = "SELECT *  FROM CRM_Client c JOIN CRM_Key k ON c.client_key = k.CRM_Key_id";
        try(PreparedStatement req = connection.prepareStatement(sql)){
            ResultSet rs = req.executeQuery();
            while(rs.next()){
                clients.add(new Client(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("mail"),
                        rs.getInt("number"),
                        new Key(rs.getString("title"),rs.getString("content"))
                ));
            }
        }
        return clients;
    }
    
    public void storeClient(Client client) throws SQLException{
        String sql = "INSERT INTO CRM_Client(firstname, lastname, mail, number, client_key) VALUES(?, ?, ?, ?, ?)";
        connection.setAutoCommit(false);
        try(PreparedStatement req = connection.prepareStatement(sql)){
            req.setString(1, client.getFirstName());
            req.setString(2, client.getLastName());
            req.setString(3, client.getMail());
            req.setInt(4, client.getNumber());
            req.setInt(5, storeClientKey(client.getKey()));
        }
        connection.commit();
        connection.setAutoCommit(true);
    }
    
    private int storeClientKey(Key key) throws SQLException{
        String sql = "INSERT INTO CRM_Key(title, content) VALUES(?, ?)";
        try(PreparedStatement req = connection.prepareStatement(sql)){
            req.setString(1, key.getTitle());
            req.setString(2, key.getContent());
            return getLastKeyInserted();
        }
    }
    
    private int getLastKeyInserted() throws SQLException{
        String sql = "SELECT MAX(CRM_Key_id) AS id FROM CRM_Key";
        try(PreparedStatement req = connection.prepareCall(sql)){
            ResultSet rs = req.executeQuery();
            return rs.getInt("id");
        }
    }
    
    public void storeMeeting(Meeting meeting){
        
    }
}
