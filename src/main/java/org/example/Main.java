package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean repetir;

        WarriorList wl = new WarriorList();
        Warrior w = new Warrior("Sofia", 100, 10, 10, 5, diceRoll.d10);

        wl.addWarrior(w);

        System.out.println("Welcome to Battle Game Simulator!!\n");

        do{
            repetir = Menu.menu(sc, wl);
        }while (repetir);

        sc.close();
    }
}