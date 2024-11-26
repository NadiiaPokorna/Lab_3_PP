package main.java.droids;

import main.java.game.Droid;

public class BasicDroid extends Droid {
    public BasicDroid(String name) {
        super(name, 100, 20);
    }

    @Override
    public void attack(Droid enemy) {
        System.out.println(this.name + " attacks " + enemy.getName() + " and deals " + this.damage + " damage!");
        enemy.takeDamage(this.damage);
    }
}
