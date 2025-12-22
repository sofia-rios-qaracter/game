package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    public static int readInt(Scanner sc, String message, String errorMessage) {
        int readedNumber = 0;
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try {
                System.out.println(message);
                readedNumber = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        } while (repeatQuestion);

        return readedNumber;
    }

    public static double readDouble(Scanner sc, String message, String errorMessage) {
        double readedNumber = 0.0;
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try {
                System.out.println(message);
                readedNumber = sc.nextDouble();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        } while (repeatQuestion);

        return readedNumber;
    }

    public static String readWord(Scanner sc, String message, String errorMessage) {
        String readedNumber = "";
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try {
                System.out.println(message);
                readedNumber = sc.next();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        } while (repeatQuestion);

        return readedNumber;
    }

    public static String readString(Scanner sc, String message, String errorMessage) {
        String readedNumber = "";
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try {
                System.out.println(message);
                readedNumber = sc.nextLine();
            } catch (InputMismatchException e) {
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        } while (repeatQuestion);

        return readedNumber;
    }

    public static int readPositiveInt(Scanner sc, String message, String errorMessageType,
            String errorBelowZero) {
        boolean repeat;
        int numberToRead;

        do {
            repeat = false;
            numberToRead = readInt(sc, message, errorMessageType);
            if (numberToRead < 0) {
                repeat = true;
                System.out.println(errorBelowZero);
            }
        } while (repeat);

        return numberToRead;
    }

    public static diceRoll readDiceRoll(Scanner sc, String message, String errorMessage) {
        String readedDiceRoll;
        boolean repeatQuestion = false;
        diceRoll response;

        do {
            repeatQuestion = false;
            System.out.println(message);
            readedDiceRoll = sc.nextLine().trim();

            switch (readedDiceRoll.toLowerCase()) {
                case "d4":
                case "4":
                    response = diceRoll.d4;
                    break;
                case "d6":
                case "6":
                    response = diceRoll.d6;
                    break;
                case "d8":
                case "8":
                    response = diceRoll.d8;
                    break;
                case "d10":
                case "10":
                    response = diceRoll.d10;
                    break;
                case "d12":
                case "12":
                    response = diceRoll.d12;
                    break;
                case "d20":
                case "20":
                    response = diceRoll.d20;
                    break;
                default:
                    repeatQuestion = true;
                    System.out.println(errorMessage);
                    break;
            }

        } while (repeatQuestion);

        return diceRoll.d10;
    }

}