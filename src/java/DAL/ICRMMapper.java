package DAL;

import Model.Client;
import Model.Key;
import Model.Meeting;
import Model.Staff;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ICRMMapper {
    void storeNewUser(String firstName, String lastNAme, String mail, int number, String password) throws SQLException, Exception;
    boolean loginUser(String username, String password) throws SQLException, Exception;
    List<Meeting> getAllMeetings() throws SQLException;
    List<Client> getAllClients() throws SQLException;
    int storeClientKey(Key key) throws SQLException;
    void storeClient(Client client) throws SQLException;
    void storeMeeting(Meeting meeting);
    List<Staff> getAllStaff();
}
