package main.java.game;

import java.util.List;

public class TeamBattle {
    private List<Droid> team1;
    private List<Droid> team2;

    public TeamBattle(List<Droid> team1, List<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void fight() {
        System.out.println("\n--- Team Battle ---");

        while (team1.stream().anyMatch(Droid::isAlive) && team2.stream().anyMatch(Droid::isAlive)) {
            for (Droid droid1 : team1) {
                if (droid1.isAlive()) {
                    Droid target = team2.stream().filter(Droid::isAlive).findFirst().orElse(null);
                    if (target != null) {
                        droid1.attack(target);
                    }
                }
            }

            for (Droid droid2 : team2) {
                if (droid2.isAlive()) {
                    Droid target = team1.stream().filter(Droid::isAlive).findFirst().orElse(null);
                    if (target != null) {
                        droid2.attack(target);
                    }
                }
            }
        }

        if (team1.stream().anyMatch(Droid::isAlive)) {
            System.out.println("Team 1 wins!");
        } else {
            System.out.println("Team 2 wins!");
        }
    }
}
