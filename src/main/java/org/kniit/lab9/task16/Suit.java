package org.kniit.lab9.task16;

public enum Suit {
    SPADES("Пики"),
    HEARTS("Черви"),
    DIAMONDS("Бубны"),
    CLUBS("Трефы");

    private final String title;

    Suit(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
