package org.kniit.lab2.task4;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private double maxVolume;
    private double freeVolume;
    private List<Shape> shapes;

    public Container(double maxVolume) {
        this.maxVolume = maxVolume;
        this.freeVolume = maxVolume;
        this.shapes = new ArrayList<>();
    }

    public boolean add(Shape shape) {
        double volume = shape.getVolume();

        if (volume <= freeVolume) {
            shapes.add(shape);
            freeVolume -= volume;
            System.out.println("Фигура добавлена. Объем: " + volume);
            System.out.println("Осталось свободного места: " + freeVolume);
            return true;
        } else {
            System.out.println("Недостаточно места. Нужно: " + volume + ", доступно: " + freeVolume);
            return false;
        }
    }

    public double getFreeVolume() {
        return freeVolume;
    }

    public int getShapeCount() {
        return shapes.size();
    }
}