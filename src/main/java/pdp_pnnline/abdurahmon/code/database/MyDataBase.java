package pdp_pnnline.abdurahmon.code.database;

import pdp_pnnline.abdurahmon.code.model.User;
import pdp_pnnline.abdurahmon.code.service.AuthService;
import pdp_pnnline.abdurahmon.code.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class MyDataBase {
    public static final List<User> users = new ArrayList<>();

    static {
        User user1 = new User("Abdurahmon", "abdurahmon@gmail.com", "Abdurahmon1");
        users.add(user1);
        User user2 = new User("user", "user@gmail.com", "Userrrr1");
        users.add(user2);

        AuthService.saveUserToFile(user1);
        AuthService.saveUserToFile(user2);
        System.out.println("Users saved to file");
    }
}
