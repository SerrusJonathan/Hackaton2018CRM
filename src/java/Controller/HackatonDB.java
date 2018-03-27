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

public class HackatonDB {

    private static final String URL = "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2228988";
    private static final String UID = "sql2228988";
    private static final String PWD = "eD1!qD3*";

    private static HackatonDB instance;

    private Connection connection;

    private HackatonDB() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, UID, PWD);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static HackatonDB getInstance() {
        if (instance == null) {
            instance = new HackatonDB();
        }
        return instance;
    }

    public void storeNewUser(String username, String password) throws SQLException {
        String sql = "INSERT INTO CRM_Password(mail, password)" + " VALUES (?,?)";
        PreparedStatement prep = this.connection.prepareStatement(sql);
        prep.setString(1, username);
        prep.setString(2, password);
        prep.executeUpdate();
        prep.close();
    }

    public boolean loginUser(String username, String password) throws SQLException {
        String sql = "select * from CRM_Password where mail=?";
        PreparedStatement prep = this.connection.prepareStatement(sql);
        prep.setString(1, username);
        ResultSet rs = prep.executeQuery();
        if (rs.next()) {
            String ControlePassword = rs.getString("password");
            if (ControlePassword.equals(password)) {
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

    public List<Meeting> getAllMeetings() throws SQLException {
        List<Meeting> meetings = new ArrayList<>();
        // Set<Integer> meetingIds = new HashSet<>();
        String sql = "SELECT m.date as date, m.title as title, m.place as place,"
                + " c.firstname as cfirstname, c.lastname as clastname, c.mail as cmail, c.number as cnumber,"
                + " s.firstname as sfirstname, s.lastname as slastname, s.mail as smail, s.number as snumber,"
                + " t.title as ttitle, t.content as tcontent, a.text as atext, a.deadline as adeadline, a.comment as acomment,"
                + " as.firstname as asfirstname, as.lastname as aslastname, as.email as asemail,as.number as asnumber"
                + " FROM CRM_Meeting m JOIN CRM_Meeting_Staffs ms ON m.CRM_Meeting_id = ms.meeting"
                + " JOIN CRM_Meeting_Topics mt ON m.CRM_Meeting_id = mt.meeting"
                + " JOIN CRM_Staff s ON ms.staff = s.CRM_Staff_id"
                + " JOIN CRM_Topic t ON mt.topic = t.CRM_Topic_id"
                + " JOIN CRM_Client c ON m.client = c.CRM_Client_id"
                + " JOIN CRM_Action a ON a.CRM_Action_id = m.action"
                + " JOIN CRM_Staff as ON a.staff = as.CRM_Staff_id";
        try (PreparedStatement req = connection.prepareStatement(sql)) {
            ResultSet rs = req.executeQuery();
//            Meeting currentMeeting = null;
            while (rs.next()) {
                meetings.add(new Meeting(rs.getString("title"),
                        rs.getString("date"),
                        rs.getString("place"),
                        new Action(rs.getString("atext"), 
                                new Client(rs.getString("asfirstname"), 
                                        rs.getString("aslastname"), 
                                        rs.getString("asemail"), 
                                        rs.getInt("asnumber")), 
                                rs.getString("adeadline"),
                                rs.getString("acomment")),
                        new Client(rs.getString("cfirstname"),
                                rs.getString("clastname"),
                                rs.getString("cmail"),
                                rs.getInt("cnumber")), 
                        new Topics(rs.getString("ttitle"),
                                rs.getString("tcontent"))));

//                if(!meetingIds.contains(rs.getInt("CRM_Meeting_id"))){
//                    meetingIds.add(rs.getInt("CRM_Meeting_id"));
//                    if(currentMeeting!=null)meetings.add(currentMeeting);
//                    currentMeeting = new Meeting(rs.getString("title"), rs.getString("date"), rs.getString("place"),
//                            new Client(rs.getString("firstname"), rs.getString("lastname"), rs.getString("mail"), rs.getInt("number")));
//                }
//                currentMeeting.addStaff(new Staff(sql, sql, sql, 0));
            }
//            if(currentMeeting!=null)meetings.add(currentMeeting);
        }
        return meetings;
    }

    public ArrayList<Client> getAllClients() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        String sql = "SELECT *  FROM CRM_Client c JOIN CRM_Key k ON c.client_key = k.CRM_Key_id";
        try (PreparedStatement req = connection.prepareStatement(sql)) {
            ResultSet rs = req.executeQuery();
            while (rs.next()) {
                clients.add(new Client(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("mail"),
                        rs.getInt("number"),
                        new Key(rs.getString("title"), rs.getString("content"))
                ));
            }
        }
        return clients;
    }

    public void storeClient(Client client) throws SQLException {
        String sql = "INSERT INTO CRM_Client(firstname, lastname, mail, number, client_key) VALUES(?, ?, ?, ?, ?)";
        connection.setAutoCommit(false);
        try (PreparedStatement req = connection.prepareStatement(sql)) {
            req.setString(1, client.getFirstName());
            req.setString(2, client.getLastName());
            req.setString(3, client.getMail());
            req.setInt(4, client.getNumber());
            req.setInt(5, storeClientKey(client.getKey()));
        }
        connection.commit();
        connection.setAutoCommit(true);
    }

    private int storeClientKey(Key key) throws SQLException {
        String sql = "INSERT INTO CRM_Key(title, content) VALUES(?, ?)";
        try (PreparedStatement req = connection.prepareStatement(sql)) {
            req.setString(1, key.getTitle());
            req.setString(2, key.getContent());
            return getLastKeyInserted();
        }
    }

    private int getLastKeyInserted() throws SQLException {
        String sql = "SELECT MAX(CRM_Key_id) AS id FROM CRM_Key";
        try (PreparedStatement req = connection.prepareCall(sql)) {
            ResultSet rs = req.executeQuery();
            return rs.getInt("id");
        }
    }

    public void storeMeeting(Meeting meeting) {

    }

    public ArrayList<Staff> getAllStaff() {
        ArrayList<Staff> staff = new ArrayList<>();
        return staff;
    }
}
