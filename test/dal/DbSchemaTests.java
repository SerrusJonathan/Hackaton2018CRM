package dal;

import com.helmo.dbchecker.DatabaseChecker;
import static com.helmo.dbchecker.matchers.ColumnMatchers.hasColumnNames;
import static com.helmo.dbchecker.matchers.ColumnMatchers.hasStringLength;
import static com.helmo.dbchecker.matchers.ColumnMatchers.hasType;
import static com.helmo.dbchecker.matchers.ColumnMatchers.nullable;
import static com.helmo.dbchecker.matchers.TableMatchers.exists;
import static java.sql.Types.*;
import java.util.Map;
import javax.persistence.*;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import org.junit.*;
import static org.junit.Assert.assertThat;

public class DbSchemaTests {

    public static String PERSISTENCE_UNIT_TESTS_NAME = "CRMPU";///TODO : change PU NAME
    private static EntityManagerFactory entityManagerFactory;
    private DatabaseChecker checker;

    @BeforeClass
    public static void setupEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_TESTS_NAME);
    }

    @Before
    public void setupDbChecker() {
        Map<String, Object> props = entityManagerFactory.getProperties();
        //entityManagerFactory.createEntityManager().getProperties();
        checker = new DatabaseChecker(
                (String) props.get("javax.persistence.jdbc.url"),
                (String) props.get("javax.persistence.jdbc.user"),
                (String) props.get("javax.persistence.jdbc.password"));
    }

    @Test
    public void matchesTableNames() {
        assertThat(checker.table("CLIENT"), exists());
        assertThat(checker.table("CLIENT_KEY"), exists());
        
        assertThat(checker.table("ACTION"), exists());
        
        
        assertThat(checker.table("MEETING"), exists());
        assertThat(checker.table("STAFF"), exists());
        assertThat(checker.table("TOPICS"), exists());
    }

   @Test
    public void matchesPrimaryKey() {
        assertThat(checker.table("CLIENT").primaryKeys(),
                hasItem(checker.table("CLIENT").column("id")));
        assertThat(checker.table("ACTION").primaryKeys(),
                hasItem(checker.table("ACTION").column("id")));
    }

    @Test
    public void checksCyclesColumns() {
        com.helmo.dbchecker.Table table = checker.table("CLIENT");

        assertThat(table.columns(), hasColumnNames("KEY_ID", "FIRSTNAME", "NUMBER"));
        assertThat(table.column("NUMBER"), hasType(INTEGER));
    }

    @After
    public void closeDbChecker() throws Exception {
        
    }

    @AfterClass
    public static void teardownEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            entityManagerFactory = null;
        }
    }
}
