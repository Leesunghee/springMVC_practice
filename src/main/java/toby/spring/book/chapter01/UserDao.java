package toby.spring.book.chapter01;

import java.sql.*;

/**
 * Created by sunghee on 2015. 12. 10..
 */
public class UserDao {

    private ConnectionMaker connectionMaker; //초기에 설정하면 사용 중에는 바뀌지 않는 읽기전용 인스턴스 변순

    //매번 새로운 값으로 바뀌는 정보를 담은 인스턴스 변수 심각한 문제가 발생한다.
    //싱글톤으로 만들어져서 멀티스레드 환경에서 사용하면 심각한 문제가 발생한다
    private Connection connection;
    private User user;

    public UserDao() {
    }

    public UserDao(ConnectionMaker connectionMaker) {
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
        this.connection = connectionMaker.makeConnection();

        PreparedStatement statement = connection.prepareStatement("select * from PUBLIC.USERS where id = ?");
        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        this.user = new User();
        this.user.setId(resultSet.getString("id"));
        this.user.setName(resultSet.getString("name"));
        this.user.setPassword(resultSet.getString("password"));

        resultSet.close();
        statement.close();
        connection.close();

        return this.user;
    }
}
