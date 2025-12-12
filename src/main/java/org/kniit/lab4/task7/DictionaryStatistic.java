package org.kniit.lab4.task7;

import java.util.Random;

public class DictionaryStatistic {
    private String[] words;
    private int dictionarySize;
    private int polindrom;
    private int maxWordLength;
    private int minWordLength;
    private char[] alphabet;
    private int[] frequency;
    private Random random;

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.random = new Random();
        calculateStatistics();
    }

    private void calculateStatistics() {
        dictionarySize = words.length;
        polindrom = 0;
        maxWordLength = 0;
        minWordLength = Integer.MAX_VALUE;
        frequency = new int[alphabet.length];

        for (String word : words) {
            if (isPalindrome(word)) {
                polindrom++;
            }

            int length = word.length();
            if (length > maxWordLength) {
                maxWordLength = length;
            }
            if (length < minWordLength) {
                minWordLength = length;
            }

            String lowerWord = word.toLowerCase();
            for (char c : lowerWord.toCharArray()) {
                for (int i = 0; i < alphabet.length; i++) {
                    if (alphabet[i] == c) {
                        frequency[i]++;
                        break;
                    }
                }
            }
        }

        if (minWordLength == Integer.MAX_VALUE) {
            minWordLength = 0;
        }
    }

    private boolean isPalindrome(String word) {
        String lowerWord = word.toLowerCase();
        int left = 0;
        int right = lowerWord.length() - 1;

        while (left < right) {
            if (lowerWord.charAt(left) != lowerWord.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String getRandomWord() {
        if (dictionarySize == 0) {
            return "";
        }
        int index = random.nextInt(dictionarySize);
        return words[index];
    }

    public void printSymbolsStat() {
        System.out.println("Статистика букв в словаре:");

        for (int i = 0; i < alphabet.length; i++) {
            if (frequency[i] > 0) {
                System.out.println(alphabet[i] + " - " + frequency[i]);
            }
        }
    }

    public void printGeneralStat() {
        System.out.println("Общая статистика словаря:");
        System.out.println("Количество слов: " + dictionarySize);
        System.out.println("Количество палиндромов: " + polindrom);
        System.out.println("Максимальная длина слова: " + maxWordLength);
        System.out.println("Минимальная длина слова: " + minWordLength);
        System.out.println("Средняя длина слова: " + getAverageWordLength());
        System.out.println("Случайное слово из словаря: " + getRandomWord());

        if (polindrom > 0) {
            System.out.println("Примеры палиндромов: ");
            printSomePalindromes(3);
        }
    }

    private double getAverageWordLength() {
        if (dictionarySize == 0) return 0;

        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        return (double) totalLength / dictionarySize;
    }

    private void printSomePalindromes(int count) {
        int printed = 0;
        for (String word : words) {
            if (isPalindrome(word)) {
                System.out.println("  - " + word);
                printed++;
                if (printed >= count) break;
            }
        }
    }

    // Геттеры
    public int getDictionarySize() { return dictionarySize; }
    public int getPolindromCount() { return polindrom; }
    public int getMaxWordLength() { return maxWordLength; }
    public int getMinWordLength() { return minWordLength; }
    public char[] getAlphabet() { return alphabet; }
    public int[] getFrequency() { return frequency; }
    public String[] getWords() { return words; }

    public String[] getWordsByLength(int length) {
        int count = 0;
        for (String word : words) {
            if (word.length() == length) {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        for (String word : words) {
            if (word.length() == length) {
                result[index++] = word;
            }
        }
        return result;
    }

    public void printMostFrequentLetters(int count) {
        System.out.println("\nСамые частые буквы:");

        int[] freqCopy = frequency.clone();

        for (int i = 0; i < Math.min(count, alphabet.length); i++) {
            int maxIndex = 0;
            for (int j = 1; j < alphabet.length; j++) {
                if (freqCopy[j] > freqCopy[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (freqCopy[maxIndex] > 0) {
                System.out.println((i+1) + ". " + alphabet[maxIndex] + " - " + freqCopy[maxIndex] + " раз");
                freqCopy[maxIndex] = -1;
            }
        }
    }
}