package toby.spring.book.chapter01;

/**
 * Created by sunghee on 2015. 12. 10..
 */
public class User {

    String id;
    String name;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setId(String id) {

        this.id = id;
    }

    String password;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
