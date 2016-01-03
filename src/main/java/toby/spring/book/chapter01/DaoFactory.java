package toby.spring.book.chapter01;

/**
 * Created by sunghee on 2016. 1. 3..
 */
public class DaoFactory {
    public UserDao userDao() {
//        toby.spring.book.chapter01.ConnectionMaker connectionMaker = new toby.spring.book.chapter01.DConnectionMaker();
//        toby.spring.book.chapter01.UserDao userDao = new toby.spring.book.chapter01.UserDao(new toby.spring.book.chapter01.DConnectionMaker());
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    public AccountDao accountDao() {
//        toby.spring.book.chapter01.ConnectionMaker connectionMaker = new toby.spring.book.chapter01.DConnectionMaker();
//        toby.spring.book.chapter01.AccountDao accountDao = new toby.spring.book.chapter01.AccountDao(new toby.spring.book.chapter01.DConnectionMaker());
        AccountDao accountDao = new AccountDao(connectionMaker());
        return accountDao;

    }


    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
