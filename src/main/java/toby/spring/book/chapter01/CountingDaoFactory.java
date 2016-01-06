package toby.spring.book.chapter01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sunghee on 2016. 1. 4..
 */
@Configuration
public class CountingDaoFactory {

    @Bean
    public UserDao userDao() {
        //생성자를 이용한 DI
//        return new UserDao(connectionMaker());

        //setter 메소드를 이용한 DI
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;

    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new DConnectionMaker();
    }
}
