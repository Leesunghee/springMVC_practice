package toby.spring.book.chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sunghee on 2016. 1. 3..
 */
public class DConnectionMaker implements ConnectionMaker {

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:/Users/sunghee/Development/database/h2", "sa", "");
    }
}
