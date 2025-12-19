package org.kniit.lab11.task24;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAOImpl();

    public void initDatabase() {
        try {
            userDAO.createTable();
            if (userDAO.findAll().isEmpty()) {
                registerUser("Admin", "admin@example.com");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка инициализации БД: " + e.getMessage());
        }
    }

    public void registerUser(String name, String email) throws SQLException {
        if (userDAO.emailExists(email)) {
            System.out.println("Ошибка: Email занят!");
            return;
        }
        userDAO.create(new User(name, email));
        System.out.println("Пользователь добавлен.");
    }

    public void listAllUsers() throws SQLException {
        List<User> users = userDAO.findAll();
        if (users.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            users.forEach(System.out::println);
        }
    }

    public void deleteUser(int id) throws SQLException {
        if (userDAO.findById(id) == null) {
            System.out.println("Пользователь не найден.");
        } else {
            userDAO.delete(id);
            System.out.println("Удалено.");
        }
    }

    public void updateUser(int id, String name, String email) throws SQLException {
        User user = userDAO.findById(id);
        if (user == null) {
            System.out.println("Пользователь не найден.");
            return;
        }
        user.setName(name);
        user.setEmail(email);
        userDAO.update(user);
        System.out.println("Обновлено.");
    }
}
