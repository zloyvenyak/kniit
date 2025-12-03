package org.kniit.lab3.task6;

public class Warrior extends Player {

    public Warrior(String name) {
        super(name, 150, 25, 15);
    }

    public void attack(Player target) {
        if (isAlive) {
            if (target.isAlive()) {
                System.out.println(name + " атакует " + target.getName() + " с силой " + attackPower);
                target.decreaseHealth(attackPower);
            } else {
                System.out.println(name + " не может атаковать мертвого " + target.getName());
            }
        } else {
            System.out.println(name + " мертв и не может атаковать");
        }
    }

    @Override
    public String toString() {
        return "Воин: " + super.toString();
    }
}