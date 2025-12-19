package org.kniit.lab10.task23;

public class Main {

    public static <T> void printType(T object) {
        if (object == null) {
            System.out.println("null");
        } else {
            System.out.println(object.getClass().getName());
        }
    }

    public static void main(String[] args) {
        printType(123);
        printType("Hello");
        printType(3.14);
        printType(new Main());
    }
}
