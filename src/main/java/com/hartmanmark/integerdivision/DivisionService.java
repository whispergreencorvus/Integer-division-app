package com.hartmanmark.integerdivision;

import com.hartmanmark.inteherdivision.exception.DividendIsLessThanDivisorException;

public class DivisionService {

    private StringBuilder result = new StringBuilder();
    private StringBuilder reminder = new StringBuilder();
    private StringBuilder quotient = new StringBuilder();
    private String quotientAsString;

    public String divide(String enteredDividend, String enteredDivisor) throws DividendIsLessThanDivisorException {
        return integerDivide(enteredDividend, enteredDivisor);
    }

    private void verify(Long dividend, Long divisor) throws DividendIsLessThanDivisorException {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero. Your solution: Undefined");
        }
        if (divisor == null || dividend == null) {
            throw new IllegalArgumentException("null");
        }
        if (dividend < divisor) {
            throw new DividendIsLessThanDivisorException("Your solution: " + dividend + " / " + divisor + " = 0");
        }
    }

    private String integerDivide(String enteredDividend, String enteredDivisor)
            throws DividendIsLessThanDivisorException {
        Long dividendAsLong = Long.parseLong(enteredDividend);
        Long divisorAsLong = new Long(enteredDivisor);
        dividendAsLong = Math.abs(dividendAsLong);
        divisorAsLong = Math.abs(divisorAsLong);
        verify(dividendAsLong, divisorAsLong);
        String[] arrayOfNumbersFromDividend = String.valueOf(dividendAsLong).split("");
        Long reminderNumber;
        long multiplyResult;
        long lengthOfDivisor = calculateLengthOfDivisor(divisorAsLong);
        Long mod;
        for (int i = 0; i < arrayOfNumbersFromDividend.length; i++) {
            reminder.append(arrayOfNumbersFromDividend[i]);
            reminderNumber = Long.parseLong(reminder.toString());
            if (reminderNumber >= divisorAsLong) {
                mod = reminderNumber % divisorAsLong;
                multiplyResult = reminderNumber / divisorAsLong * divisorAsLong;
                String lastReminder = String.format("%" + (i + 2) + "s", "_" + reminderNumber.toString());
                result.append(lastReminder + "nl");
                String multiply = String.format("%" + (i + 2) + "d", multiplyResult);
                result.append(multiply + "nl");
                long difference = lastReminder.length() - calculateLengthOfDivisor(multiplyResult);
                result.append(createSeparator(multiplyResult, difference) + "nl");
                quotient.append(reminderNumber / divisorAsLong);
                reminder.replace(0, reminder.length(), mod.toString());
                reminderNumber = Long.parseLong(reminder.toString());
            } else {
                if (i >= lengthOfDivisor) {
                    quotient.append(0);
                }
            }
            if (i == arrayOfNumbersFromDividend.length - 1) {
                result.append((String.format("%" + (i + 2) + "s", reminderNumber.toString()) + "nl"));
            }
        }
        quotientAsString = quotient.toString();
        setQuotient(quotientAsString);
        return result.toString();
    }

    private String createSeparator(long reminderNumber, long tab) {
        return composeString(tab, ' ') + composeString(calculateLengthOfDivisor(reminderNumber), '-');
    }

    private long calculateLengthOfDivisor(long lengthOfDivisor) {
        return (long) Math.log10(lengthOfDivisor) + 1;
    }

    private String composeString(long numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }

    public String getQuotient() {
        return quotientAsString;
    }

    public void setQuotient(String quo) {
        this.quotientAsString = quo;
    }
}
