package org.kniit.lab9.task14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        String input = scanner.nextLine().trim().toUpperCase();

        try {
            TrafficLight currentLight = TrafficLight.valueOf(input);

            TrafficLight nextLight = currentLight.getNextLight();

            System.out.println("Следующий сигнал: " + nextLight);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: Введен недопустимый сигнал. Используйте RED, YELLOW или GREEN.");
        }
    }
}
