package pdp_pnnline.abdurahmon.code;

import pdp_pnnline.abdurahmon.code.model.User;
import pdp_pnnline.abdurahmon.code.service.AuthService;

public class Main {
    public static User user = null;

    public static void main(String[] args) {
        AuthService.run();
    }
}