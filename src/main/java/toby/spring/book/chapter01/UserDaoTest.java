package toby.spring.book.chapter01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

/**
 * Created by sunghee on 2015. 12. 10..
 */
public class UserDaoTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1. 1장 초난감 DAO
//        toby.spring.book.chapter01.UserDao userDao = new toby.spring.book.chapter01.NUserDao();

//        toby.spring.book.chapter01.ConnectionMaker connectionMaker = new toby.spring.book.chapter01.DConnectionMaker();
//
//        toby.spring.book.chapter01.UserDao userDao = new toby.spring.book.chapter01.UserDao(connectionMaker);

//        UserDao userDao = new DaoFactory().userDao();

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao userDao = context.getBean("userDao", UserDao.class);



//        User user = new User();
//        user.setId("realwunz");
//        user.setName("이성희");
//        user.setPassword("4542");
//
//        userDao.add(user);
//
//        System.out.println("user 등록 성공");
//
//        User user2 = userDao.get("realwunz");
//        System.out.println(user2.getName());
//        System.out.println(user2.getPassword());
//        System.out.println(user2.getId() + "조회 성공");

        //2. 동일성 비교
        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();

        System.out.println(dao1);
        System.out.println(dao2);

        UserDao dao3 = context.getBean("userDao", UserDao.class);
        UserDao dao4 = context.getBean("userDao", UserDao.class);

        System.out.println(dao3);
        System.out.println(dao4);
    }
}
