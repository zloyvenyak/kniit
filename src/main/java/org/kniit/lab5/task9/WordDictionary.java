package org.kniit.lab5.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordDictionary {
    private String filePath;
    private List<String> words;

    public WordDictionary(String filePath) {
        this.filePath = filePath;
        this.words = new ArrayList<>();
        loadWords();
    }

    private void loadWords() {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }

            scanner.close();
            System.out.println("Загружено " + words.size() + " слов из файла " + filePath);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден: " + filePath);
            System.err.println("Создайте файл " + filePath + " и добавьте в него слова");
        }
    }

    public List<String> getWords() {
        return new ArrayList<>(words);
    }

    public int getWordCount() {
        return words.size();
    }
}