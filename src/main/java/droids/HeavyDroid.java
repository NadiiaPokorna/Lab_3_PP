package main.java.droids;

import main.java.game.Droid;

public class HeavyDroid extends Droid {
    public HeavyDroid(String name) {
        super(name, 230, 15);
    }

    @Override
    public void attack(Droid enemy) {
        System.out.println(this.name + " smashes " + enemy.getName() + " and deals " + this.damage + " damage!");
        enemy.takeDamage(this.damage);
    }
}
