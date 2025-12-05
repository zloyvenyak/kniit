package org.kniit.lab5.task8;

import java.util.Objects;
import java.util.Random;

public class ShopItem {
    private String name;
    private double price;
    private int quantity;

    public ShopItem(String name) {
        this.name = name;
        this.price = generateRandomPrice();
        this.quantity = generateRandomQuantity();
    }

    private double generateRandomPrice() {
        Random random = new Random();
        return 10 + random.nextDouble() * 990;
    }

    private int generateRandomQuantity() {
        Random random = new Random();
        return 1 + random.nextInt(100);
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return String.format("ShopItem{name='%s', price=%.2f, quantity=%d}",
                name, price, quantity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ShopItem shopItem = (ShopItem) obj;
        return Objects.equals(name, shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}