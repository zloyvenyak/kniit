package org.kniit.lab3.task6;

public class Mage extends Player {

    public Mage(String name) {
        super(name, 100, 30, 5);
    }

    public void castSpell(Player target) {
        if (isAlive) {
            if (target.isAlive()) {
                int spellPower = attackPower * 2;
                System.out.println(name + " кастует заклинание на " + target.getName() +
                        " с силой " + spellPower);
                target.decreaseHealth(spellPower);
            } else {
                System.out.println(name + " не может кастовать на мертвого " + target.getName());
            }
        } else {
            System.out.println(name + " мертв и не может кастовать заклинания");
        }
    }

    @Override
    public String toString() {
        return "Маг: " + super.toString();
    }
}