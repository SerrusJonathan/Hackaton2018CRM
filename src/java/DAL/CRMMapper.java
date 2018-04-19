package DAL;

import Model.Client;
import Model.Key;
import Model.Meeting;
import Model.PasswordHashing.PasswordHashing;
import Model.Person;
import Model.Staff;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CRMMapper implements ICRMMapper{

	private EntityManagerFactory entityManagerFactory;
	private EntityManager session;

        public CRMMapper(EntityManagerFactory em) {
            this.entityManagerFactory = em;
            session = entityManagerFactory.createEntityManager();
        }

    @Override
    public void storeNewUser(String firstName, String lastNAme, String mail, int number, String password) throws SQLException, Exception {
        Person p = new Staff(firstName, lastNAme);
        p.setEmail(mail);
        p.setNumber(number);
        p.setPassword(password);
        session.persist(p);
        
    }

    @Override
    public boolean loginUser(String username, String password) throws SQLException, Exception {
        TypedQuery<Staff> q = session.createQuery("select * from Staff where mail= :username", Staff.class);
        Person p = q.setParameter("username", username).getSingleResult();
        if(p == null) return false;
        String staffPassword = p.getPassword();
        return PasswordHashing.check(password, staffPassword);
    }

    @Override
    public List<Meeting> getAllMeetings() throws SQLException {
        Query q = session.createQuery("SELECT m FROM Meeting m", Meeting.class);
        return q.getResultList();
    }

    @Override
    public List<Client> getAllClients() throws SQLException {
        Query q = session.createQuery("SELECT c FROM Client c", Client.class);
        return q.getResultList();
    }

    @Override
    public int storeClientKey(Key key) throws SQLException {
        session.persist(key);
        return 0;
    }


    @Override
    public void storeClient(Client client) throws SQLException {
        session.persist(client);
    }

    @Override
    public void storeMeeting(Meeting meeting) {
        session.persist(meeting);
    }

    @Override
    public List<Staff> getAllStaff() {
        Query q = session.createQuery("SELECT s FROM Staff s", Staff.class);
        return q.getResultList();
    }

}