package dao;

import java.util.ArrayList;
import java.util.List;

public class userDAO {

    private static List<user> users = new ArrayList<>();

    static {
        users.add(new user("admin", "1234", "admin"));
        users.add(new user("user", "1234", "user"));
    }

    public user findByLoginAndPassword(String login, String password) {
        for (user u : users) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
