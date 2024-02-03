package pdp_pnnline.abdurahmon.code.service;

import pdp_pnnline.abdurahmon.code.Main;
import pdp_pnnline.abdurahmon.code.model.User;
import pdp_pnnline.abdurahmon.code.util.MyScanner;
import pdp_pnnline.abdurahmon.code.validation.DtoValidation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class UserService {
    public static void userRun() {
        int option;
        do {
            option = userMenu();

            switch (option) {
                case 1 -> sendMessage();
                case 0 -> {
                    AuthService.logout();
                    return;
                }
                default -> System.out.println("Try again bro");
            }
        } while (true);
    }


    private static void sendMessage() {
        String receiverEmail, message;

        System.out.println("Enter receiver email ");
        receiverEmail = MyScanner.IN_STR.next();

        while (!DtoValidation.checkEmail(receiverEmail)) {
            System.out.println("Enter receiver email ");
            receiverEmail = MyScanner.IN_STR.next();
        }

        System.out.println("Enter message ");
        message = MyScanner.IN_STR.nextLine();

        while (message == null || message.isBlank()) {
            System.out.println("Enter message ");
            message = MyScanner.IN_STR.nextLine();
        }

        System.out.println("Message sent");

        saveToMessagesTxt(Main.user, receiverEmail, message);
    }

    public static void saveToMessagesTxt(User user, String receiverEmail, String message) {
        try (FileWriter fileWriter = new FileWriter("user_messages.txt", true)) {
            fileWriter.write(user.getEmail() + " -> "
                    + receiverEmail + " : "
                    + message + "\n" + "Time - "
                    + System.currentTimeMillis() +
                    "\n");
            Logger logger = Logger.getLogger(UserService.class.getName());
            logger.info("Message saved");
        } catch (IOException ignore) {
        }
    }

    private static byte userMenu() {
        System.out.print("""
                1. Send message
                0. Exit - 
                """);
        return MyScanner.IN_NUM.nextByte();
    }
}