package org.kniit.lab10.task22;

public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        dictionary.put("Charlie", 35);

        System.out.println("Возраст Alice: " + dictionary.get("Alice")); // 25
        System.out.println("Возраст Bob: " + dictionary.get("Bob"));     // 30

        dictionary.put("Alice", 26);
        System.out.println("Новый возраст Alice: " + dictionary.get("Alice")); // 26

        dictionary.remove("Bob");
        System.out.println("Поиск Bob после удаления: " + dictionary.get("Bob")); // null
    }
}
