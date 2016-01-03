package toby.spring.book.chapter01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sunghee on 2016. 1. 3..
 */
public class AccountDao {
    private ConnectionMaker connectionMaker;

    public AccountDao() {
    }

    public AccountDao(ConnectionMaker connectionMaker) {
        //simpleConnectionMaker = new toby.spring.book.chapter01.SimpleConnectionMaker();
        //connectionMaker = new toby.spring.book.chapter01.DConnectionMaker();
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        //Connection connection = makeConnection();
        Connection connection = connectionMaker.makeConnection();


        PreparedStatement statement = connection.prepareStatement("insert into PUBLIC.USERS(id, name, password) values (?, ?, ?)");
        statement.setString(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPassword());

        statement.execute();


        statement.close();
        connection.close();

    }

//    public abstract Connection makeConnection() throws ClassNotFoundException, SQLException;

    public User get(String id) throws ClassNotFoundException, SQLException {
        //Connection connection = makeConnection();
        Connection connection = connectionMaker.makeConnection();

        PreparedStatement statement = connection.prepareStatement("select * from PUBLIC.USERS where id = ?");
        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        statement.close();
        connection.close();

        return user;
    }
}
