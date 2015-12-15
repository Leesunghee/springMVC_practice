import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sunghee on 2015. 12. 10..
 */
public class NUserDao extends UserDao {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:/Users/sunghee/Development/database/h2", "sa", "");
    }
}
