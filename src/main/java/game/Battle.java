package main.java.game;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Battle {
    private Droid droid1;
    private Droid droid2;

    public Battle(Droid droid1, Droid droid2) {
        this.droid1 = droid1;
        this.droid2 = droid2;
    }

    public void fight() {
        System.out.println("\n--- 1v1 Battle: " + droid1.getName() + " vs " + droid2.getName() + " ---");
        while (droid1.isAlive() && droid2.isAlive()) {
            droid1.attack(droid2);
            if (droid2.isAlive()) {
                droid2.attack(droid1);
            }
        }

        if (droid1.isAlive()) {
            System.out.println(droid1.getName() + " wins!");
        } else {
            System.out.println(droid2.getName() + " wins!");
        }

        saveBattleResult(droid1, droid2);
    }

    private void saveBattleResult(Droid droid1, Droid droid2) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("battle_result.txt"))) {
            writer.println("Battle Result:");
            writer.println(droid1);
            writer.println(droid2);
        } catch (IOException e) {
            System.out.println("Error saving battle result.");
        }
    }
}
