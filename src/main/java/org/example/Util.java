package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    public static int readInt(Scanner sc, String message, String errorMessage){
        int readedNumber = 0;
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try{
                System.out.println(message);
                readedNumber = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        }while (repeatQuestion);

        return readedNumber;
    }

    public static double readDouble(Scanner sc, String message, String errorMessage){
        double readedNumber = 0.0;
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try{
                System.out.println(message);
                readedNumber = sc.nextDouble();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        }while (repeatQuestion);

        return readedNumber;
    }

    public static String readWord(Scanner sc, String message, String errorMessage){
        String readedNumber = "";
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try{
                System.out.println(message);
                readedNumber = sc.next();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        }while (repeatQuestion);

        return readedNumber;
    }

    public static String readString(Scanner sc, String message, String errorMessage){
        String readedNumber = "";
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try{
                System.out.println(message);
                readedNumber = sc.nextLine();
            } catch (InputMismatchException e) {
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        }while (repeatQuestion);

        return readedNumber;
    }

}