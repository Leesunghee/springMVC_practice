package toby.spring.book.chapter01;

import java.sql.*;

/**
 * Created by sunghee on 2016. 1. 3..
 */
public class SimpleConnectionMaker {
    public java.sql.Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:/Users/sunghee/Development/database/h2", "sa", "");
    }
}
