package org.kniit.lab3.task6;

public class WarriorGuard extends Warrior {
    private int additionalDefense;

    public WarriorGuard(String name) {
        super(name);
        this.additionalDefense = 10;
        this.maxHealth += 20;  // У стража больше здоровья
        this.health = maxHealth;
        this.defense += additionalDefense;
    }

    @Override
    public void decreaseHealth(int value) {
        if (isAlive) {
            int totalDefense = defense + additionalDefense;
            int damage = value - totalDefense;

            if (damage > 0) {
                health -= damage;
                System.out.println(name + " (Страж) получил урон " + damage + " единиц");
            } else {
                System.out.println(name + " (Страж) заблокировал весь урон своей броней!");
            }

            if (health <= 0) {
                health = 0;
                isAlive = false;
                System.out.println(name + " (Страж) погиб!");
            } else {
                System.out.println(name + " (Страж) имеет " + health + " здоровья");
            }
        }
    }

    @Override
    public String toString() {
        return "Страж: " + super.toString().replace("Воин: ", "") +
                ", Доп. защита: " + additionalDefense;
    }
}