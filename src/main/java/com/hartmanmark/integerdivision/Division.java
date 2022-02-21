package com.hartmanmark.integerdivision;

public class Division {

    private StringBuilder result = new StringBuilder();
    private StringBuilder quotient = new StringBuilder();
    private StringBuilder reminder = new StringBuilder();

    public String divide(String enteredDividend, String enteredDivisor) {
        Long dividend = Long.parseLong(enteredDividend);
        Long divisor = Long.parseLong(enteredDivisor);
        return integerDivide(dividend, divisor);
    }

    private String integerDivide(Long dividend, Long divisor) {
           if (divisor == 0) {
               throw new IllegalArgumentException("Divisor cannot be 0, division by zero. Your solution: Undefined");
            //System.out.println("Divisor cannot be 0, division by zero. Your solution: Undefined");
            //System.out.println("Your solution: Undefined");

        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < divisor) {
            return dividend + " / " + divisor + " = 0";
        }
        String[] arrayOfNumbersFromDividend = String.valueOf(dividend).split("");
        Long reminderNumber;
        Long multiplyResult;
        Long lengthOfDivisor = calculateLengthOfDivisor(divisor);
        Long mod;
        for (int i = 0; i < arrayOfNumbersFromDividend.length; i++) {
            reminder.append(arrayOfNumbersFromDividend[i]);
            reminderNumber = Long.parseLong(reminder.toString());
            if (reminderNumber >= divisor) {
                mod = reminderNumber % divisor;
                multiplyResult = reminderNumber / divisor * divisor;
                String lastReminder = String.format("%" + (i + 2) + "s", "_" + reminderNumber.toString());
                result.append(lastReminder).append("\n");
                String multiply = String.format("%" + (i + 2) + "d", multiplyResult);
                result.append(multiply).append("\n");
                Long difference = lastReminder.length() - calculateLengthOfDivisor(multiplyResult);
                result.append(createSeparator(reminderNumber, difference)).append("\n");
                quotient.append(reminderNumber / divisor);
                reminder.replace(0, reminder.length(), mod.toString());
                reminderNumber = Long.parseLong(reminder.toString());
            } else {
                if (i >= lengthOfDivisor) {
                    quotient.append(0);
                }
            }
            if (i == arrayOfNumbersFromDividend.length - 1) {
                result.append(String.format("%" + (i + 2) + "s", reminderNumber.toString())).append("\n");
            }
        }
        modifyResultToView(dividend, divisor);
        return result.toString();
    }

    private String createSeparator(Long reminderNumber, Long tab) {
        return composeString(tab, ' ') + composeString(calculateLengthOfDivisor(reminderNumber), '-');
    }

    private void modifyResultToView(Long dividend, Long divisor) {
        int[] index = new int[3];
        int j = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }
            if (j == 3) {
                break;
            }
        }
        long indent = calculateLengthOfDivisor(dividend) + 1 - index[0];
        result.insert(index[2], composeString(indent, ' ') + "│" + quotient.toString());
        result.insert(index[1], composeString(indent, ' ') + "│" + composeString(quotient.length(), '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend.toString());
    }

    private long calculateLengthOfDivisor(long i) {
        return (long) Math.log10(i) + 1;
    }

    private String composeString(long numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}
