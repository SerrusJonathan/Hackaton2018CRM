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

    private static final String URL = "";
    private static final String UID = "";
    private static final String PWD = "";
    
    // statische variabele die een verwijzing naar onze ene instantie (singleton pattern) zal bijhouden
    private static HackatonDB instance;
    
    // verwijzing naar de databaseconnectie
    private Connection connection;
    
    // constructor is private --> singleton pattern
    private HackatonDB()
    {
        try
        {
            // MySQL-driver registreren
            Class.forName("com.mysql.jdbc.Driver");
            
            // connectie ophalen en openen
            connection = DriverManager.getConnection(URL, UID, PWD);
        }
        catch (ClassNotFoundException ex)
        {
            // deze exception kan optreden als de registratie van de MySQL-driver mislukt
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            // deze exception kan vb. optreden bij het mislukken van het openen van de DB-connectie
            ex.printStackTrace();
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
    
    
}
