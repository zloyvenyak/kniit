package org.kniit.lab6.task10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HangmanGame {
    private WordDictionary dictionary;
    private GameStatistics statistics;
    private Scanner scanner;
    private static final int MAX_ATTEMPTS = 6;

    public HangmanGame() {
        this.dictionary = new WordDictionary();
        this.statistics = new GameStatistics();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Правила:");
        System.out.println("1. У вас есть " + MAX_ATTEMPTS + " попыток, чтобы угадать слово");
        System.out.println("2. Вводите по одной русской букве");
        System.out.println("3. Если введете одну и ту же букву повторно - попытка не тратится");
        System.out.println("4. _ - означает неотгаданную букву");
        System.out.println();

        boolean playAgain = true;

        while (playAgain) {
            playSingleGame();

            System.out.println("\nХотите сыграть еще раз? (да/нет)");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("да") || response.equals("д");
            scanner.nextLine();
        }

        System.out.println("\nСтатистика:");
        statistics.displayStatistics();
        System.out.println("\nСпасибо за игру!");
        scanner.close();
    }

    private void playSingleGame() {
        String secretWord = dictionary.getRandomWord();

        if (secretWord == null) {
            return;
        }

        List<Character> guessedWord = initializeGuessedWord(secretWord);
        Set<Character> guessedLetters = new HashSet<>();
        Set<Character> wrongLetters = new HashSet<>();
        int attemptsLeft = MAX_ATTEMPTS;

        System.out.println("Длина слова: " + secretWord.length() + " букв");

        while (attemptsLeft > 0 && !isWordGuessed(guessedWord)) {
            displayGameStatus(guessedWord, attemptsLeft, wrongLetters);
            System.out.print("Введите букву: ");

            String input = scanner.next().toLowerCase();

            if (input.length() != 1) {
                System.out.println("Ошибка! Введите одну букву.");
                continue;
            }

            char letter = input.charAt(0);

            if (!isRussianLetter(letter)) {
                System.out.println("Ошибка! Введите русскую букву.");
                continue;
            }

            if (guessedLetters.contains(letter) || wrongLetters.contains(letter)) {
                System.out.println("Вы уже вводили эту букву!");
                continue;
            }

            if (secretWord.indexOf(letter) >= 0) {
                revealLetter(secretWord, guessedWord, letter);
                guessedLetters.add(letter);
                System.out.println("Верно! Буква '" + letter + "' есть в слове.");
            } else {
                wrongLetters.add(letter);
                attemptsLeft--;
                System.out.println("Неверно! Буквы '" + letter + "' нет в слове.");
                System.out.println("Осталось попыток: " + attemptsLeft);
            }
        }

        if (isWordGuessed(guessedWord)) {
            System.out.println("\nПоздравляю! Вы угадали слово: " + secretWord);
            statistics.incrementWins();
        } else {
            System.out.println("\nВы проиграли.");
            System.out.println("Загаданное слово было: " + secretWord);
            statistics.incrementLosses();
        }
    }

    private List<Character> initializeGuessedWord(String secretWord) {
        List<Character> guessedWord = new ArrayList<>();
        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord.add('_');
        }
        return guessedWord;
    }

    private boolean isWordGuessed(List<Character> guessedWord) {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private void revealLetter(String secretWord, List<Character> guessedWord, char letter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                guessedWord.set(i, letter);
            }
        }
    }

    private void displayGameStatus(List<Character> guessedWord, int attemptsLeft, Set<Character> wrongLetters) {
        System.out.println("\nТекущее состояние слова:");
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }

        if (!wrongLetters.isEmpty()) {
            System.out.println("\nНеверные буквы: " + wrongLetters);
        }

        System.out.println("Попыток осталось: " + attemptsLeft);
    }

    private boolean isRussianLetter(char c) {
        return (c >= 'а' && c <= 'я') || c == 'ё';
    }
}