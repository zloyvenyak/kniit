package org.kniit.lab5.task9;

public class TestStatistics {
    private int totalWords;
    private int correctWords;
    private int totalCharacters;

    public TestStatistics() {
        this.totalWords = 0;
        this.correctWords = 0;
        this.totalCharacters = 0;
    }

    public void incrementTotalWords() {
        totalWords++;
    }

    public void incrementCorrectWords() {
        correctWords++;
    }

    public void addCharactersTyped(int count) {
        totalCharacters += count;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public int getCorrectWords() {
        return correctWords;
    }

    public int getTotalCharacters() {
        return totalCharacters;
    }

    public void reset() {
        totalWords = 0;
        correctWords = 0;
        totalCharacters = 0;
    }
}