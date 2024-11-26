package main.java.game;

import main.java.droids.BasicDroid;
import main.java.droids.HeavyDroid;
import main.java.droids.SpeedDroid;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Droid> droids = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Create droid");
            System.out.println("2. Show all droids");
            System.out.println("3. Start 1v1 battle");
            System.out.println("4. Start team battle");
            System.out.println("5. Play saved battle");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createDroid(scanner);
                    break;
                case 2:
                    showDroids();
                    break;
                case 3:
                    start1v1Battle(scanner);
                    break;
                case 4:
                    startTeamBattle(scanner);
                    break;
                case 5:
                    playSavedBattle();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void createDroid(Scanner scanner) {
        System.out.println("Choose droid type: 1. Basic, 2. Heavy, 3. Speed");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter droid name:");
        String name = scanner.nextLine();

        Droid droid = null;
        switch (type) {
            case 1:
                droid = new BasicDroid(name);
                break;
            case 2:
                droid = new HeavyDroid(name);
                break;
            case 3:
                droid = new SpeedDroid(name);
                break;
            default:
                System.out.println("Invalid type.");
                return;
        }

        droids.add(droid);
        System.out.println(droid.getName() + " created.");
    }

    private static void showDroids() {
        if (droids.isEmpty()) {
            System.out.println("No droids created.");
        } else {
            for (int i = 0; i < droids.size(); i++) {
                System.out.println((i + 1) + ". " + droids.get(i));
            }
        }
    }

    private static void start1v1Battle(Scanner scanner) {
        if (droids.size() < 2) {
            System.out.println("Not enough droids for a battle. Create more droids.");
            return;
        }

        System.out.println("Choose first droid:");
        showDroids();
        int droid1Index = scanner.nextInt() - 1;

        System.out.println("Choose second droid:");
        showDroids();
        int droid2Index = scanner.nextInt() - 1;

        Droid droid1 = droids.get(droid1Index);
        Droid droid2 = droids.get(droid2Index);

        Battle battle = new Battle(droid1, droid2);
        battle.fight();
    }

    private static void startTeamBattle(Scanner scanner) {
        if (droids.size() < 4) {
            System.out.println("Not enough droids for a team battle. Create more droids.");
            return;
        }

        System.out.println("\n--- Select 2 droids for the first team ---");
        List<Droid> team1 = selectTeam(scanner);

        System.out.println("\n--- Select 2 droids for the second team ---");
        List<Droid> team2 = selectTeam(scanner);

        TeamBattle battle = new TeamBattle(team1, team2);
        battle.fight();
    }

    private static List<Droid> selectTeam(Scanner scanner) {
        List<Droid> team = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Select droid " + (i + 1) + ":");
            showDroids();
            int index = scanner.nextInt();
            team.add(droids.get(index - 1));
        }
        return team;
    }

    private static void playSavedBattle() {
        try (FileReader reader = new FileReader("battle_result.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("Error reading battle result.");
        }
    }
}
