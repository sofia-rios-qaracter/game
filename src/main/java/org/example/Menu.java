package org.example;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public static boolean menu(Scanner sc, WarriorList warriors) {
        int menuOption;
        boolean repeat = true;
        Warrior warrior;

        System.out.println("Do you have a warrior? Press 1 to load it.");
        System.out.println("Do you want to create a new warrior? Press 2 to load it.");
        System.out.println("Do you want to see all selected warrior? Press 3 to see them!");
        System.out.println("Let's battle!! Press 4 to fight!!");
        System.out.println("If you want to leave, please press 5");
        menuOption = Util.readInt(sc, "Choose your option!", "You must type a number");

        switch (menuOption) {
            case 1:
                warrior = loadWarrior(sc);
                if (warrior != null)
                    warriors.addWarrior(warrior);
                Util.readString(sc, "Press enter to coninue", "");
                break;
            case 2:
                warrior = createWarrior(sc);
                if (warrior != null)
                    warriors.addWarrior(warrior);
                Util.readString(sc, "Press enter to coninue", "");
                break;
            case 3:
                System.out.println(warriors);
                Util.readString(sc, "Press enter to coninue", "");
                break;
            case 4:
                Combat.combatMenu(sc, warriors);
                break;
            case 5:
                repeat = false;
                System.out.println("Closing the program. Have a nice day!");
                break;
            default:
                System.out.println("You have to type some of the posible options!!");
                Util.readWord(sc, "Press enter to coninue", "");
                break;
        }
        return repeat;
    }

    public static Warrior loadWarrior(Scanner sc) {
        System.out.println("Not implemented yet");
        return null;
    }

    public static Warrior createWarrior(Scanner sc) {
        System.out.println("Not implemented yet");
        return null;
    }
}
