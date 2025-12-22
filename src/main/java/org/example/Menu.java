package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    public static boolean menu(Scanner sc, WarriorList warriors) {
        int menuOption;
        boolean repeat = true;
        Warrior warrior;

        System.out.println(
                "Do you have a warrior? " + Color.BOLD + Color.GREEN + "Press 1" + Color.RESET + " to load it.");
        System.out.println("Do you want to create a new warrior? " + Color.BOLD + Color.GREEN + "Press 2" + Color.RESET
                + " to add it.");
        System.out.println("Do you want to see all selected warrior? " + Color.BOLD + Color.GREEN + "Press 3"
                + Color.RESET + " to see them!");
        System.out.println("Let's battle!! " + Color.BOLD + Color.GREEN + "Press 4" + Color.RESET + " to fight!!");
        System.out.println("If you want to leave, please " + Color.BOLD + Color.GREEN + "press 5" + Color.RESET);
        menuOption = Util.readInt(sc, Color.BOLD + "Choose your option!" + Color.RESET, GeneralMessages.MUST_INT);

        switch (menuOption) {
            case 1:
                warrior = loadWarrior(sc);
                if (warrior != null)
                    warriors.addWarrior(warrior);

                Util.readString(sc, GeneralMessages.PRESS_ENTER, "");
                break;
            case 2:
                warrior = createWarrior(sc, warriors);
                if (warrior != null) {
                    warriors.addWarrior(warrior);
                    System.out.println("Warrior added succesfully!");
                    System.out.println(warrior);
                }

                Util.readString(sc, GeneralMessages.PRESS_ENTER, "");
                break;
            case 3:
                System.out.println(warriors);
                Util.readString(sc, GeneralMessages.PRESS_ENTER, "");
                break;
            case 4:
                Combat.combatMenu(sc, warriors);
                break;
            case 5:
                repeat = false;
                System.out.println("Closing the program. Have a nice day!");
                break;
            default:
                Util.soutError("You have to type some of the posible options!!");
                Util.readWord(sc, GeneralMessages.PRESS_ENTER, "");
                break;
        }
        return repeat;
    }

    public static Warrior loadWarrior(Scanner sc) {
        System.out.println("Not implemented yet");
        return null;
    }

    public static Warrior createWarrior(Scanner sc, WarriorList warriors) {
        String name = Arrays.stream(Util.readString(sc, "What's the warrior name?", "").trim().split("\\s+"))
                .map(singularName -> singularName.substring(0, 1).toUpperCase()
                        + singularName.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        if (warriors.getWarrior(name) != null) {
            Util.soutError("You must add another warrior, there is already one with that name!");
            return null;
        }

        int hp = Util.readPositiveInt(sc, "What's the warrior health points?", GeneralMessages.MUST_INT,
                "Health points cannot be negative!");

        int attack = Util.readPositiveInt(sc, "What's the warrior atack?", GeneralMessages.MUST_INT,
                "Attack must be positive!");

        int defense = Util.readPositiveInt(sc, "What's the warrior defense?", GeneralMessages.MUST_INT,
                "Defense must be positive!");

        int speed = Util.readPositiveInt(sc, "What's the warrior speed?", GeneralMessages.MUST_INT,
                "Speed must be positive!");

        diceRoll roll = Util.readDiceRoll(sc, "What's the dice of damage the warrior does?",
                "Dices avaiable are d4, d6, d8, d10, d12 and d20. Please, choose one of those options");

        return new Warrior(name, hp, defense, attack, speed, roll);
    }
}
