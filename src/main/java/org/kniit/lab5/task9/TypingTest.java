package org.kniit.lab5.task9;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class TypingTest {
    private WordDictionary dictionary;
    private TestStatistics statistics;
    private Scanner scanner;
    private Random random;

    public TypingTest() {
        this.dictionary = new WordDictionary("misc/dictionary.txt");
        this.statistics = new TestStatistics();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void startTest() {
        List<String> words = dictionary.getWords();
        if (words.isEmpty()) {
            System.out.println("Словарь пуст! Добавьте слова в файл misc/dictionary.txt");
            return;
        }

        System.out.println("Тест на скорость печати");
        System.out.println("У вас есть 1 минута. Вводите слова, которые появляются на экране.");
        System.out.println("Нажмите Enter, чтобы начать.");
        scanner.nextLine();

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 60000;

        while (System.currentTimeMillis() < endTime) {
            String randomWord = words.get(random.nextInt(words.size()));
            System.out.println("Введите слово: " + randomWord);

            long wordStartTime = System.currentTimeMillis();
            String userInput = scanner.nextLine();
            long wordEndTime = System.currentTimeMillis();

            if (wordEndTime > endTime) {
                System.out.println("Время вышло! Это слово не учитывается.");
                break;
            }

            statistics.incrementTotalWords();
            statistics.addCharactersTyped(userInput.length());

            if (userInput.equalsIgnoreCase(randomWord)) {
                statistics.incrementCorrectWords();
                System.out.println("Верно!");
            } else {
                System.out.println("Неверно. Правильно: " + randomWord);
            }

            System.out.println();
        }

        scanner.close();
        displayResults(startTime);
    }

    private void displayResults(long startTime) {
        System.out.println("\nРезультаты:");
        System.out.println("Всего слов показано: " + statistics.getTotalWords());
        System.out.println("Правильных слов: " + statistics.getCorrectWords());
        System.out.println("Всего символов введено: " + statistics.getTotalCharacters());

        long totalTimeMs = System.currentTimeMillis() - startTime;
        double totalTimeSec = totalTimeMs / 1000.0;

        if (totalTimeSec > 0) {
            double charsPerSecond = statistics.getTotalCharacters() / totalTimeSec;
            System.out.printf("Скорость печати: %.2f символов в секунду\n", charsPerSecond);
        }

        if (statistics.getTotalWords() > 0) {
            double accuracy = (double) statistics.getCorrectWords() / statistics.getTotalWords() * 100;
            System.out.printf("Точность: %.1f%%\n", accuracy);
        }
    }
}