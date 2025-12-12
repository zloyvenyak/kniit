package org.kniit.lab8.task13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static final String FILE_NAME = "users.ser";

    public static void saveUsers(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
            System.out.println("Список успешно сохранён в файл " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<User> loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Файл не найден — возвращаем пустой список (нормальная ситуация для первого запуска)
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке файла: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
