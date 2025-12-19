package org.kniit.lab9.task14;

public enum TrafficLight {
    RED,
    YELLOW,
    GREEN;

    public TrafficLight getNextLight() {
        switch (this) {
            case RED:
                return YELLOW;
            case YELLOW:
                return GREEN;
            case GREEN:
                return RED;
            default:
                throw new IllegalStateException("Неизвестный сигнал: " + this);
        }
    }
}
