package main.java.droids;

import main.java.game.Droid;

public class SpeedDroid extends Droid {
    public SpeedDroid(String name) {
        super(name, 80, 25);
    }

    @Override
    public void attack(Droid enemy) {
        System.out.println(this.name + " quickly hits " + enemy.getName() + " and deals " + this.damage + " damage!");
        enemy.takeDamage(this.damage);
    }
}
