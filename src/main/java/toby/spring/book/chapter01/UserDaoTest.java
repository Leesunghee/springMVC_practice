package toby.spring.book.chapter01;

import java.sql.SQLException;

/**
 * Created by sunghee on 2015. 12. 10..
 */
public class UserDaoTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //toby.spring.book.chapter01.UserDao userDao = new toby.spring.book.chapter01.NUserDao();

//        toby.spring.book.chapter01.ConnectionMaker connectionMaker = new toby.spring.book.chapter01.DConnectionMaker();
//
//        toby.spring.book.chapter01.UserDao userDao = new toby.spring.book.chapter01.UserDao(connectionMaker);

        UserDao userDao = new DaoFactory().userDao();

        User user = new User();
        user.setId("realwunz");
        user.setName("이성희");
        user.setPassword("4542");

        userDao.add(user);

        System.out.println("user 등록 성공");

        User user2 = userDao.get("realwunz");
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + "조회 성공");
    }
}
