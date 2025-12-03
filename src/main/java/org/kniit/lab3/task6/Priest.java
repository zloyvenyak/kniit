package org.kniit.lab3.task6;

public class Priest extends Player {
    private int healPower;

    public Priest(String name) {
        super(name, 120, 10, 8);
        this.healPower = 20;
    }

    public void heal(Player target) {
        if (isAlive) {
            if (target.isAlive()) {
                System.out.println(name + " лечит " + target.getName() +
                        " на " + healPower + " единиц здоровья");
                target.increaseHealth(healPower);
            } else {
                System.out.println(name + " не может лечить мертвого " + target.getName());
            }
        } else {
            System.out.println(name + " мертв и не может лечить");
        }
    }

    @Override
    public String toString() {
        return "Священник: " + super.toString() + ", Сила лечения: " + healPower;
    }
}