package toby.spring.book.chapter01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sunghee on 2016. 1. 3..
 */

@Configuration
public class DaoFactory {
//    public UserDao userDao() {
////        toby.spring.book.chapter01.ConnectionMaker connectionMaker = new toby.spring.book.chapter01.DConnectionMaker();
////        toby.spring.book.chapter01.UserDao userDao = new toby.spring.book.chapter01.UserDao(new toby.spring.book.chapter01.DConnectionMaker());
//        UserDao userDao = new UserDao(connectionMaker());
//        return userDao;
//    }
//
//    public AccountDao accountDao() {
////        toby.spring.book.chapter01.ConnectionMaker connectionMaker = new toby.spring.book.chapter01.DConnectionMaker();
////        toby.spring.book.chapter01.AccountDao accountDao = new toby.spring.book.chapter01.AccountDao(new toby.spring.book.chapter01.DConnectionMaker());
//        AccountDao accountDao = new AccountDao(connectionMaker());
//        return accountDao;
//
//    }

    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
