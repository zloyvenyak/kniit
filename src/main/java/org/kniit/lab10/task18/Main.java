package org.kniit.lab10.task18;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 30);

        System.out.println("Первый элемент: " + pair.getFirst());
        System.out.println("Второй элемент: " + pair.getSecond());

        pair.setSecond(35);
        System.out.println("Обновленный второй элемент: " + pair.getSecond()); // Вывод: 35
    }
}
