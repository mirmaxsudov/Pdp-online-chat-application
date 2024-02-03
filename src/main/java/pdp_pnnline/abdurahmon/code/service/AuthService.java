package pdp_pnnline.abdurahmon.code.service;

import pdp_pnnline.abdurahmon.code.Main;
import pdp_pnnline.abdurahmon.code.database.MyDataBase;
import pdp_pnnline.abdurahmon.code.model.User;
import pdp_pnnline.abdurahmon.code.util.MyScanner;
import pdp_pnnline.abdurahmon.code.validation.DtoValidation;

import java.util.stream.Collectors;

public class AuthService {

    public static void run() {

        int option;

        do {
            if (Main.user == null) {
                option = mainMenu();

                switch (option) {
                    case 1 -> login();
                    case 2 -> signUp();
                    case 0 -> {
                        return;
                    }
                }
            } else {
                UserService.userRun();
            }
        } while (true);

    }

    public static void logout() {
        Main.user = null;
    }

    private static void signUp() {
        String email, password, name;

        System.out.print("Enter your name ");
        name = MyScanner.IN_STR.nextLine();

    }

    private static void login() {
        String email, password;

        System.out.print("Enter your email ");
        email = MyScanner.IN_STR.next();

        if (!DtoValidation.checkEmail(email)) {
            System.out.print("Enter your email ");
            email = MyScanner.IN_STR.next();
        }

        System.out.print("Enter your password ");
        password = MyScanner.IN_STR.next();
        if (password == null || password.isBlank()) {
            System.out.print("Enter your password ");
            password = MyScanner.IN_STR.next();
        }

        User user = getUserFromDatabase(email, password);
        if (user == null) {
            System.out.println("There is no user with this email");
        } else {
            Main.user = user;
            System.out.println("Successfully log inned");
        }
    }

    public static boolean existUserFromDatabase(String email, String password) {
        return MyDataBase.users
                .stream()
                .filter(
                        user ->
                                user.getEmail().equals(email) && user.getPassword().equals(password))
                .count() == 1;
    }

    public static User getUserFromDatabase(String email, String password) {
        return MyDataBase.users
                .stream()
                .filter(
                        user ->
                                user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    private static byte mainMenu() {
        System.out.println("""
                1. Login
                2. Sign up
                0. Exit 
                """);
        return MyScanner.IN_NUM.nextByte();
    }
}