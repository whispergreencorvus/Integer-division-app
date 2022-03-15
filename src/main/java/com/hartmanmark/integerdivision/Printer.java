package com.hartmanmark.integerdivision;

import com.hartmanmark.inteherdivision.exception.DividendIsLessThanDivisorException;
import com.hartmanmark.inteherdivision.exception.DivisorIsZeroException;

public class Printer {

    private StringBuilder result = new StringBuilder();
    private String quotient;

    public String print(String dividend, String divisor) throws DividendIsLessThanDivisorException, DivisorIsZeroException {
        DivisionValidator divisionValidator = new DivisionValidator();
        divisionValidator.verify(dividend, divisor);
        DivisionService service = new DivisionService();
        String[] arrayOfIntermediateDivisionResults = service.divide(dividend, divisor).split("nl");
        quotient = service.getQuotient();
        for (String i : arrayOfIntermediateDivisionResults) {
            result.append(i + "\n");
        }
        long dividendAsLong = Long.parseLong(dividend);
        long divisorAsLong = Long.parseLong(divisor);
        modifyResultToView(dividendAsLong, divisorAsLong);
        return result.toString();
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
        result.insert(index[2], composeString(indent, ' ') + "│" + quotient);
        result.insert(index[1], composeString(indent, ' ') + "│" + composeString(quotient.length(), '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend.toString());
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
}
