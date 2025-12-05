package org.kniit.lab5.task8;

import java.util.Comparator;

public class PriceComparator implements Comparator<ShopItem> {
    @Override
    public int compare(ShopItem item1, ShopItem item2) {
        return Double.compare(item1.getPrice(), item2.getPrice());
    }
}