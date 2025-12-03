package org.kniit.lab4.task7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("misc/dictionary.txt"));
            ArrayList<String> wordList = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().trim();
                if (!word.isEmpty()) {
                    wordList.add(word);
                }
            }
            fileScanner.close();

            String[] words = wordList.toArray(new String[0]);
            System.out.println("Прочитано слов: " + words.length);

            char[] russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();

            DictionaryStatistic stats = new DictionaryStatistic(words, russianAlphabet);

            System.out.println("\n" + "=".repeat(50));
            stats.printGeneralStat();

            System.out.println("\n" + "=".repeat(50));
            stats.printSymbolsStat();

            stats.printMostFrequentLetters(5);

            System.out.println("\nПримеры слов разной длины:");

            int minLen = stats.getMinWordLength();
            int maxLen = stats.getMaxWordLength();

            if (minLen > 0) {
                String[] shortestWords = stats.getWordsByLength(minLen);
                if (shortestWords.length > 0) {
                    System.out.println("Самые короткие слова (" + minLen + " букв):");
                    for (int i = 0; i < Math.min(3, shortestWords.length); i++) {
                        System.out.println("  - " + shortestWords[i]);
                    }
                }
            }

            if (maxLen > 0 && maxLen != minLen) {
                String[] longestWords = stats.getWordsByLength(maxLen);
                if (longestWords.length > 0) {
                    System.out.println("\nСамые длинные слова (" + maxLen + " букв):");
                    for (int i = 0; i < Math.min(3, longestWords.length); i++) {
                        System.out.println("  - " + longestWords[i]);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл dictionary.txt не найден!");

            System.out.println("\nРабота с тестовым словарем:");
            String[] testWords = {"кот", "топот", "шалаш", "программа", "алфавит"};
            char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();

            DictionaryStatistic testStats = new DictionaryStatistic(testWords, alphabet);
            testStats.printGeneralStat();
            testStats.printSymbolsStat();

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}