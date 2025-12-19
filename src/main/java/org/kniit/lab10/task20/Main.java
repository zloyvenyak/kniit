package org.kniit.lab10.task20;

public class Main {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.add(10);
        integerBox.add(20);
        System.out.println("Сумма целых чисел: " + integerBox.sum());

        Box<Double> doubleBox = new Box<>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        System.out.println("Сумма дробных чисел: " + doubleBox.sum());

        Box<Number> numberBox = new Box<>();
        numberBox.add(10);
        numberBox.add(5.5);
        System.out.println(numberBox.sum());
    }
}
