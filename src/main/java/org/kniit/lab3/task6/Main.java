package org.kniit.lab3.task6;

public class Main {
    public static void main(String[] args) {
        WarriorGuard warrior = new WarriorGuard("Страшный Орк");
        Mage mage = new Mage("Могучий Маг");
        Priest priest = new Priest("Святой Целитель");
        Warrior warrior2 = new Warrior("Обычный Воин");

        System.out.println("\nНачальное состояние: ");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);
        System.out.println(warrior2);

        System.out.println("\nХод битвы");

        System.out.println("\n1. Атака воина на мага:");
        warrior.attack(mage);

        System.out.println("\n2. Священник лечит мага:");
        priest.heal(mage);

        System.out.println("\n3. Маг кастует заклинание на стража:");
        mage.castSpell(warrior);

        System.out.println("\n4. Страж атакует обычного воина:");
        warrior.attack(warrior2);

        System.out.println("\n5. Священник лечит себя:");
        priest.heal(priest);

        System.out.println("\n6. Персонажи перемещаются:");
        warrior.move(10, 5);
        mage.move(3, 8);
        priest.move(7, 2);

        System.out.println("\n7. Маг кастует на священника:");
        mage.castSpell(priest);

        System.out.println("\n8. Воин добивает мага:");
        warrior.attack(mage);
        warrior.attack(mage);
        warrior.attack(mage);

        System.out.println("\n9. Попытка вылечить мертвого мага:");
        priest.heal(mage);

        System.out.println("\n10. Попытка атаковать мертвого мага:");
        warrior2.attack(mage);

        System.out.println("\nФинальное состояние:");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);
        System.out.println(warrior2);

        System.out.println("\nИтоги:");
        System.out.println("Живые персонажи:");
        Player[] players = {warrior, mage, priest, warrior2};
        for (Player player : players) {
            if (player.isAlive()) {
                System.out.println("- " + player.getName());
            }
        }
    }
}