package pdp_pnnline.abdurahmon.code.service;

import pdp_pnnline.abdurahmon.code.util.MyScanner;

public class UserService {
    public static void userRun() {
        int option;
        do {
            option = userMenu();

            switch (option) {
                case 1 -> sendMessage();
                case 2 -> seeMessages();
                case 0 -> {
                    AuthService.logout();
                    return;
                }
                default -> System.out.println("Try again bro");
            }
        } while (true);
    }

    private static void seeMessages() {

    }

    private static void sendMessage() {

    }

    private static byte userMenu() {
        System.out.print("""
                1. Send message
                2. See own message
                0. Exit - 
                """);
        return MyScanner.IN_NUM.nextByte();
    }

}