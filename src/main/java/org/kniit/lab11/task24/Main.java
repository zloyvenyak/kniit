package org.kniit.lab11.task24;

import java.util.Scanner;

public class Main {
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        userService.initDatabase();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Команды: add [name] [email], list, delete [id], update [id] [name] [email], exit");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");

            if (parts.length == 0 || parts[0].isEmpty()) continue;

            try {
                switch (parts[0].toLowerCase()) {
                    case "add":
                        if (parts.length < 3) System.out.println("Формат: add Name Email");
                        else userService.registerUser(parts[1], parts[2]);
                        break;
                    case "list":
                        userService.listAllUsers();
                        break;
                    case "delete":
                        if (parts.length < 2) System.out.println("Формат: delete ID");
                        else userService.deleteUser(Integer.parseInt(parts[1]));
                        break;
                    case "update":
                        if (parts.length < 4) System.out.println("Формат: update ID Name Email");
                        else userService.updateUser(Integer.parseInt(parts[1]), parts[2], parts[3]);
                        break;
                    case "exit":
                        return;
                    default:
                        System.out.println("Неизвестная команда.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
