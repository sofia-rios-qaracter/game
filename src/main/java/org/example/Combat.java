package org.example;

import java.util.List;
import java.util.Scanner;

public class Combat {
    public static void combatMenu(Scanner sc, WarriorList warriors) {
        Rolls r = new Rolls();
        List<Warrior> warriorsOrder;
        List<Warrior> oponents;
        Warrior oponent;

        boolean enoughWarriors;
        int oponentToHit = 0;
        int turn = 0;

        if (!warriors.atLeatTwo()) {
            System.out.println("You must add more warriors!\nAt least are needed 2 warriors to fight.\n");
            return;
        }

        do {
            turn++;
            warriorsOrder = warriors.battleOrder(r);
            System.out.println("-----");
            System.out.println("Order for the turn " + turn + ".");

            warriorsOrder.forEach(warrior -> {
                System.out.println(warrior.getName() + " has rolled an "
                        + warrior.getRolledSpeed() + " for a total of "
                        + (warrior.getSpeed() + warrior.getRolledSpeed()));
            });

            System.out.println("-----");
            Util.readString(sc, "Press enter to continue", "");

            for (Warrior warrior : warriorsOrder) {
                if (warrior.isDead()) {
                    System.out.println(warrior.getName() +
                            " has fallen already! So their turn is skipped\n");
                } else {
                    System.out.println("It's " + warrior.getName() + " turn!");

                    oponents = warriors.oponents(warrior);
                    if (oponents.size() >= 2) {
                        System.out.println("Who do you want to hit? Type the given number for each one");

                        for (int i = 0; i < oponents.size(); i++) {
                            System.out.println((i + 1) + " " + oponents.get(i).getName());
                        }
                        do {
                            oponentToHit = Util.readInt(sc, "So who's the 'lucky' one? ",
                                    "Please type a number") - 1;

                            if (oponentToHit < 0 || oponentToHit >= oponents.size()) {
                                System.out.println("Please choose a number between the given ones!");
                            }
                        } while (oponentToHit < 0 || oponentToHit >= oponents.size());
                        oponent = warriors.getWarrior(oponents.get(oponentToHit).getName());
                    } else {
                        oponent = warriors.getWarrior(oponents.get(0).getName());
                    }

                    fightBetweenTwo(warrior, oponent, r);
                    System.out.println();
                    Util.readString(sc, "Press enter to continue", "");
                }
            }

            enoughWarriors = warriors.canStillFigth();
        } while (enoughWarriors);

        System.out.println("The fight is over! The winner is: " + Color.GREEN + Color.BOLD + Color.UNDERLAYED
                + warriors.winner().getName()
                + Color.RESET + "\nCongratulations!!");
    }

    public static void fightBetweenTwo(Warrior atacker, Warrior defender, Rolls r) {
        System.out.println(atacker.getName() + " attack!");
        System.out.println(atacker.getName() + " has rolled a " + atacker.rolledForAtack(r)
                + " with a total of " + (atacker.getAttack() + atacker.getRolledAtack()));

        if (atacker.getRolledAtack() + atacker.getAttack() > defender.getDefense()) {
            System.out.println(
                    "Surpasing " + defender.getName() + " who have " + defender.getDefense()
                            + " defense");
            System.out.println(atacker.getName() + " has rolled " + atacker.rolledForDamage(r)
                    + " to damage!");
            defender.gettingHited(atacker.getRolledDamage());

            if (defender.getActualHealthPoints() == 0) {
                System.out.println(Color.RED + defender.getName() + " has fainted" + Color.RESET);
            } else {
                System.out.println(defender.getName() + " have " + defender.showHP() + "health points left");
            }
        } else {
            System.out.println("The attack have failed!");
        }
    }
}
