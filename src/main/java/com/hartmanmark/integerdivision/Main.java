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
                scanner.close();
                break;
            }
            System.out.print("Enter your divisor: ");
            enteredDivisor = scanner.nextLine();
            if (!DivisionUtils.isNumeric(enteredDividend) || !DivisionUtils.isNumeric(enteredDivisor)) {
                throw new IllegalArgumentException("The input have to me a number");
            }

            DivisionService division = new DivisionService();
            try {
                intermediateDivisionResults = division.divide(enteredDividend, enteredDivisor);
                Printer print = new Printer();
                System.out.println("Your solution: " + "\n" + print.print(intermediateDivisionResults,
                    division.getQuotient(), enteredDividend, enteredDivisor));
            } catch (IllegalArgumentException e) {
               throw  new DividendIsLessThanDivisorException("Dividend is less than divisor");
            }
        }
    }
}
