package com.hartmanmark.integerdivision;

import java.util.Scanner;

import com.hartmanmark.inteherdivision.exception.DividendIsLessThanDivisorException;

public class Main {

    public static void main(String[] args) throws DividendIsLessThanDivisorException {
        Scanner scanner = new Scanner(System.in);
        String enteredDividend;
        String enteredDivisor;
        String intermediateDivisionResults = null;
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
                System.out.println(
                        "Incorrect input dividend or divisor. Input data must be number. Try again. For output write [exit]");
            }
        }
        scanner.close();
        DivisionService division = new DivisionService();
        try {
            intermediateDivisionResults = division.divide(enteredDividend, enteredDivisor);
            Printer print = new Printer();
            System.out.println("Your solution: " + "\n" + print.print(intermediateDivisionResults,
                    division.getQuotient(), enteredDividend, enteredDivisor));
        } catch (DividendIsLessThanDivisorException e) {
            System.out.println(e.getMessage());
        }
    }
}
