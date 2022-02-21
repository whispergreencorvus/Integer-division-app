package com.hartmanmark.integerdivision;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String enteredDividend;
        String enteredDivisor;
        while (true) {
            System.out.print("Enter your dividend: ");
            enteredDividend = scanner.nextLine();
            if (enteredDividend.matches("\\d+")) {
                break;
            } else if (enteredDividend.equals("exit")) {
                System.out.println("Bye bye");
                System.exit(0);
            } else if (!enteredDividend.matches("\\d+")) {
                System.out.println("Incorrect input dividend. Try again. For output write [exit]");
            }
        }
        while (true) {
            System.out.print("Enter your divisor: ");
            enteredDivisor = scanner.nextLine();
            if (enteredDivisor.matches("\\d+")) {
                break;
            } else if (enteredDivisor.equals("exit")) {
                System.out.println("Bye bye");
                System.exit(0);
            } else if (!enteredDivisor.matches("\\d+")) {
                System.out.println("Incorrect input divisor. Try again. For output write [exit]");
            }
        }
        scanner.close();
        Division division = new Division();
        System.out.print("Your solution: " + "\n\n" + division.divide(enteredDividend, enteredDivisor));
    }
}
