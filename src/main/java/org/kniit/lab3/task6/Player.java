package org.kniit.lab3.task6;

public abstract class Player {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected boolean isAlive;
    protected int positionX;
    protected int positionY;
    protected int attackPower;
    protected int defense;

    public Player(String name, int maxHealth, int attackPower, int defense) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.defense = defense;
        this.isAlive = true;
        this.positionX = 0;
        this.positionY = 0;
    }

    public void increaseHealth(int value) {
        if (isAlive) {
            health += value;
            if (health > maxHealth) {
                health = maxHealth;
            }
            System.out.println(name + " восстановил здоровье. Текущее здоровье: " + health);
        }
    }

    public void decreaseHealth(int value) {
        if (isAlive) {
            int damage = value - defense;
            if (damage > 0) {
                health -= damage;
                System.out.println(name + " получил урон " + damage + " единиц");
            } else {
                System.out.println(name + " заблокировал весь урон!");
            }

            if (health <= 0) {
                health = 0;
                isAlive = false;
                System.out.println(name + " погиб!");
            } else {
                System.out.println(name + " имеет " + health + " здоровья");
            }
        }
    }

    public void move(int x, int y) {
        if (isAlive) {
            positionX = x;
            positionY = y;
            System.out.println(name + " переместился на позицию (" + x + ", " + y + ")");
        } else {
            System.out.println(name + " мертв и не может двигаться");
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return name + " [Здоровье: " + health + "/" + maxHealth +
                ", Атака: " + attackPower + ", Защита: " + defense +
                ", Позиция: (" + positionX + ", " + positionY + ")" +
                ", Жив: " + (isAlive ? "Да" : "Нет") + "]";
    }

    // Геттеры
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getPositionX() { return positionX; }
    public int getPositionY() { return positionY; }
    public int getAttackPower() { return attackPower; }
    public int getDefense() { return defense; }
}