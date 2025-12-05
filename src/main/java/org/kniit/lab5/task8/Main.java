package org.kniit.lab5.task8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] names = {"книга", "ручка", "линейка", "карандаш"};
        Random random = new Random();

        ShopItem[] items = new ShopItem[100];

        for (int i = 0; i < items.length; i++) {
            int index = random.nextInt(names.length);
            items[i] = new ShopItem(names[index]);
        }

        System.out.println("\nДо сортировки (первые 10)");
        for (int i = 0; i < 10; i++) {
            System.out.println(items[i]);
        }

        Arrays.sort(items, new PriceComparator());

        System.out.println("\nПосле сортировки по цене (первые 10)");
        for (int i = 0; i < 10; i++) {
            System.out.println(items[i]);
        }

        System.out.println("\nПодсчёт одинаковых товаров");

        Map<String, Integer> countMap = new HashMap<>();
        for (ShopItem item : items) {
            String name = item.getName();
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " шт.");
        }

        System.out.println("\nИтоги: ");
        System.out.println("Всего товаров: " + items.length);
        System.out.println("Уникальных имен: " + countMap.size());
    }
}