package org.kniit.lab6.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordDictionary {
    private List<String> words;
    private static final String FILE_PATH = "misc/dictionary.txt";

    public WordDictionary() {
        words = new ArrayList<>();
        loadWords();
    }

    private void loadWords() {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim().toLowerCase();
                if (word.length() >= 4 && word.matches("[а-яё]+")) {
                    words.add(word);
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл словаря не найден: " + FILE_PATH);
            System.out.println("Создайте файл " + FILE_PATH + " и добавьте в него слова (каждое слово на новой строке)");
        }
    }

    public String getRandomWord() {
        if (words.isEmpty()) {
            System.out.println("Словарь пуст! Добавьте слова в файл " + FILE_PATH);
            return null;
        }
        int randomIndex = (int) (Math.random() * words.size());
        return words.get(randomIndex);
    }

    public int getWordCount() {
        return words.size();
    }
}