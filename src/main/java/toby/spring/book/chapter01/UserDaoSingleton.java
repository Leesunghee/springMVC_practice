package toby.spring.book.chapter01;

/**
 * Created by sunghee on 2016. 1. 4..
 */
public class UserDaoSingleton {
    private static UserDaoSingleton INSTANCE;

    private UserDaoSingleton() {

    }

    public static synchronized UserDaoSingleton getInstance() {
        if (INSTANCE == null) { INSTANCE = new UserDaoSingleton(); }
        return INSTANCE;
    }
}
