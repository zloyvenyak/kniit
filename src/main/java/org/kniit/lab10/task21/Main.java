package org.kniit.lab10.task21;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry");
        List<String> filteredWords = FilterUtils.filter(words, s -> s.startsWith("b"));

        System.out.println("Слова на 'b': " + filteredWords);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = FilterUtils.filter(numbers, n -> n % 2 == 0);

        System.out.println("Четные числа: " + evenNumbers);

        List<String> shortWords = FilterUtils.filter(words, s -> s.length() == 5);
        System.out.println("Слова из 5 букв: " + shortWords);
    }
}
