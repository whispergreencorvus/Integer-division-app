package com.hartmanmark.integerdivision;

import com.hartmanmark.inteherdivision.exception.DividendIsLessThanDivisorException;
import com.hartmanmark.inteherdivision.exception.DivisorIsZeroException;

public class DivisionValidator {
    public void verify(String dividend, String divisor) throws DividendIsLessThanDivisorException, DivisorIsZeroException {
        long dividendAsLong = Long.parseLong(dividend);
        long divisorAsLong = Long.parseLong(divisor);
        if (divisorAsLong == 0) {
            throw new DivisorIsZeroException(
                    "Divisor cannot be 0, division by zero." + "\n" + "Your solution: Undefined");
        }
        if (divisor == null || dividend == null) {
            throw new NumberFormatException("null");
        }
        if (dividendAsLong < divisorAsLong) {
            throw new DividendIsLessThanDivisorException("Your solution: " + dividendAsLong + " / " + divisorAsLong + " = 0");
        }
    }
}
