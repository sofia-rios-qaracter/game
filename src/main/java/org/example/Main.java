package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean repetir;

        WarriorList wl = new WarriorList();
        Warrior w1 = new Warrior("Sofia", 10, 10, 5, 5, diceRoll.d10);
        Warrior w2 = new Warrior("Celeste", 10, 10, 5, 5, diceRoll.d10);
        Warrior w3 = new Warrior("Marta", 10, 10, 5, 5, diceRoll.d10);

        wl.addWarrior(w1);
        wl.addWarrior(w2);
        wl.addWarrior(w3);

        System.out.println("Welcome to Battle Game Simulator!!\n");

        do {
            repetir = Menu.menu(sc, wl);
        } while (repetir);

        sc.close();
    }
}