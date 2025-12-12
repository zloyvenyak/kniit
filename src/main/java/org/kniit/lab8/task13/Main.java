package org.kniit.lab8.task13;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // При запуске пытаемся загрузить данные
        List<User> users = UserManager.loadUsers();

        System.out.println("Добро пожаловать в систему управления пользователями!");

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить нового пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("3. Сохранить список пользователей в файл");
            System.out.println("4. Загрузить список пользователей из файла");
            System.out.println("5. Выйти");
            System.out.print("\nВведите номер действия: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addUser(scanner, users);
                    break;
                case "2":
                    showUsers(users);
                    break;
                case "3":
                    UserManager.saveUsers(users);
                    break;
                case "4":
                    List<User> loadedUsers = UserManager.loadUsers();
                    if (loadedUsers != null) {
                        users = loadedUsers;
                        System.out.println("Список успешно загружен из файла.");
                    }
                    break;
                case "5":
                    // Автосохранение перед выходом
                    UserManager.saveUsers(users);
                    System.out.println("Программа завершена. До свидания!");
                    return;
                default:
                    System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }
    }

    private static void addUser(Scanner scanner, List<User> users) {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.nextLine();

        int age = 0;
        while (true) {
            System.out.print("Введите возраст: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число.");
            }
        }

        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        users.add(new User(name, age, email));
        System.out.println("Пользователь добавлен.");
    }

    private static void showUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
        } else {
            System.out.println("Список пользователей:");
            for (int i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + ". " + users.get(i));
            }
        }
    }
}
