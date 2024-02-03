package pdp_pnnline.abdurahmon.code.database;

import pdp_pnnline.abdurahmon.code.model.User;

import java.util.ArrayList;
import java.util.List;

public class MyDataBase {
    public static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("Abdurahmon", "abdurahmon@gmail.com", "Abdurahmon1"));
        users.add(new User("user", "user@gmail.com", "Userrrr1"));
    }
}
