package toby.spring.book.chapter01;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sunghee on 2016. 1. 4..
 */
public class CountingConnectionMaker implements ConnectionMaker {
    int counter = 0;
    private ConnectionMaker realConnectionMaker;

    public CountingConnectionMaker() {

    }

    public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
        this.realConnectionMaker = realConnectionMaker;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return this.realConnectionMaker.makeConnection();
    }

    public int getCounter() {
        return this.counter;
    }
}
