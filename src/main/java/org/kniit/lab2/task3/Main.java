package org.kniit.lab2.task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Калькулятор. Для выхода введите 'exit'");

        while (true) {
            try {
                System.out.print("Введите первое число: ");
                String firstInput = scanner.nextLine();

                if (firstInput.equals("exit")) {
                    System.out.println("Выход из программы.");
                    break;
                }

                double num1 = Double.parseDouble(firstInput);

                System.out.print("Введите оператор (+, -, *, /): ");
                String operator = scanner.nextLine();

                System.out.print("Введите второе число: ");
                String secondInput = scanner.nextLine();

                if (secondInput.equals("exit")) {
                    System.out.println("Выход из программы.");
                    break;
                }

                double num2 = Double.parseDouble(secondInput);

                double result;
                switch (operator) {
                    case "+":
                        result = calculator.add(num1, num2);
                        break;
                    case "-":
                        result = calculator.subtract(num1, num2);
                        break;
                    case "*":
                        result = calculator.multiply(num1, num2);
                        break;
                    case "/":
                        result = calculator.divide(num1, num2);
                        break;
                    default:
                        System.out.println("Ошибка: Неподдерживаемая операция");
                        continue;
                }

                System.out.println("Результат: " + result);
                System.out.println();

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное число");
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}