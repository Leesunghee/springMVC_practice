import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sunghee on 2015. 12. 10..
 */
public class NUserDao extends UserDao {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        return DriverManager.getConnection("jdbc:hsqldb:file:root");
    }
}
