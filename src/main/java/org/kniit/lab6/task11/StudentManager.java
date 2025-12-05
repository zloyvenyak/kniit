package org.kniit.lab6.task11;

import java.util.Scanner;
import java.util.TreeSet;

public class StudentManager {
    private TreeSet<String> students;
    private Scanner scanner;

    public StudentManager() {
        students = new TreeSet<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    showAllStudents();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nМЕНЮ:");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента");
        System.out.println("3. Показать всех студентов");
        System.out.println("4. Найти студента");
        System.out.println("5. Выйти");
        System.out.print("Выберите опцию: ");
    }

    private int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void addStudent() {
        System.out.print("Введите ФИО студента: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Ошибка: Имя не может быть пустым.");
            return;
        }

        if (students.contains(name)) {
            System.out.println("Ошибка: Студент с именем '" + name + "' уже существует.");
        } else {
            students.add(name);
            System.out.println("Студент '" + name + "' успешно добавлен.");
        }
    }

    private void removeStudent() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }

        System.out.print("Введите ФИО студента для удаления: ");
        String name = scanner.nextLine().trim();

        if (students.remove(name)) {
            System.out.println("Студент '" + name + "' успешно удален.");
        } else {
            System.out.println("Студент с именем '" + name + "' не найден.");
        }
    }

    private void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }

        System.out.println("Список студентов (" + students.size() + " чел.):");

        int counter = 1;
        for (String student : students) {
            System.out.println(counter + ". " + student);
            counter++;
        }
    }

    private void findStudent() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }

        System.out.print("Введите ФИО студента для поиска: ");
        String name = scanner.nextLine().trim();

        if (students.contains(name)) {
            System.out.println("Студент '" + name + "' найден в списке.");
        } else {
            System.out.println("Студент с именем '" + name + "' не найден.");
        }
    }

    public int getStudentCount() {
        return students.size();
    }
}