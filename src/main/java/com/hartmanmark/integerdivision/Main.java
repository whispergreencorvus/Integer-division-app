package com.hartmanmark.integerdivision;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String enteredDividend;
        String enteredDivisor;
        System.out.println("Welcome to simple integer division application. For output input [exit]");
        while (true) {
            System.out.print("Enter your dividend: ");
            enteredDividend = scanner.nextLine();
            if (enteredDividend.equals("exit")) {
                System.out.println("Bye bye");
                System.exit(0);
            }
            System.out.print("Enter your divisor: ");
            enteredDivisor = scanner.nextLine();
            if (enteredDivisor.equals("exit")) {
                System.out.println("Bye bye");
                System.exit(0);
            }
            if (enteredDividend.matches("\\d+") && enteredDivisor.matches("\\d+")) {
                break;
            } else if (!enteredDividend.matches("\\d+") || !enteredDivisor.matches("\\d+")) {
                System.out.println("Incorrect input dividend or divisor. Input data must be number. Try again. For output write [exit]");
            }
        }
        scanner.close();
        Division division = new Division();
        String intermediateDivisionResults = division.divide(enteredDividend, enteredDivisor);
        Print print = new Print();
        System.out.println("Your solution: " + "\n" + print.print(intermediateDivisionResults, division.getQuotient(), enteredDividend, enteredDivisor));
    }
}
