package org.kniit.lab6.task10;

public class GameStatistics {
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;

    public GameStatistics() {
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesLost = 0;
    }

    public void incrementWins() {
        gamesPlayed++;
        gamesWon++;
    }

    public void incrementLosses() {
        gamesPlayed++;
        gamesLost++;
    }

    public void displayStatistics() {
        System.out.println("Всего сыграно игр: " + gamesPlayed);
        System.out.println("Выиграно: " + gamesWon);
        System.out.println("Проиграно: " + gamesLost);

        if (gamesPlayed > 0) {
            double winRate = (double) gamesWon / gamesPlayed * 100;
            System.out.printf("Процент побед: %.1f%%\n", winRate);
        }
    }
}