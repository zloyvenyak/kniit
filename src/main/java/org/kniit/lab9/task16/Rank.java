package org.kniit.lab9.task16;

public enum Rank {
    TWO("2"), THREE("3"), FOUR("4"), FIVE("5"),
    SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
    JACK("Валет"), QUEEN("Дама"), KING("Король"), ACE("Туз");

    private final String title;

    Rank(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
