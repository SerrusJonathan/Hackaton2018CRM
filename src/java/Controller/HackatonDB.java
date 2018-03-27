package Controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class  HackatonDB
{

    private static final String URL = "jdbc:sqlite:sql2.freemysqlhosting.net:3306/sql2228988";
    private static final String UID = "sql2228988";
    private static final String PWD = "eD1!qD3*";
    
    private static HackatonDB instance;
    
    private Connection connection;
    
    private HackatonDB()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            
            connection = DriverManager.getConnection(URL, UID, PWD);
        }
        catch (ClassNotFoundException ex)
        {
            throw new RuntimeException(ex);
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
        connection.close();
    }
    
    public boolean loginUser(String     username, String password) throws SQLException{
        String sql = "select * from password where playerName=?";
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
}
