package toby.spring.book.chapter01;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sunghee on 2016. 1. 3..
 */
public interface ConnectionMaker {

    public Connection makeConnection() throws ClassNotFoundException, SQLException;

}
