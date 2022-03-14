package com.hartmanmark.integerdivision;

import java.util.Scanner;

import com.hartmanmark.inteherdivision.exception.DividendIsLessThanDivisorException;
import com.hartmanmark.inteherdivision.exception.DivisorIsZeroException;

public class Main {

    public static void main(String[] args) throws DividendIsLessThanDivisorException, DivisorIsZeroException {
        Scanner scanner = new Scanner(System.in);
        String enteredDividend = null;
        String enteredDivisor = null;
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
            if (enteredDividend.matches("\\d+") && enteredDivisor.matches("\\d+")) {
                try {
                    Printer print = new Printer();
                    DivisionService division = new DivisionService();
                    System.out.println(
                            "Your solution: " + "\n" + print.print(division.divide(enteredDividend, enteredDivisor),
                                    division.getQuotient(), enteredDividend, enteredDivisor));
                } catch (DividendIsLessThanDivisorException e) {
                    System.out.println(e.getMessage());
                } catch (DivisorIsZeroException e) {
                    System.out.println(e.getMessage());
                }

            } else if (!enteredDividend.matches("\\d+") || !enteredDivisor.matches("\\d+")) {
                System.out.println(
                        "Incorrect input dividend or divisor. Input data must be number. Try again. For output write [exit]");
            }
        }
    }
}
