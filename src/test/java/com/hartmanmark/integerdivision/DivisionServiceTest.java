package com.hartmanmark.integerdivision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hartmanmark.inteherdivision.exception.DividendIsLessThanDivisorException;

class DivisionServiceTest {

    private DivisionService division;

    @BeforeEach
    void init() {
        division = new DivisionService();
    }

    @Test
    void divide_shouldReturnSolutionOnLongDividionwithoutCalculator_whenInputStringContains_12345_13()
            throws DividendIsLessThanDivisorException {
        assertEquals("_123nl 117nl ---nl  _64nl   52nl   --nl  _125nl   117nl   ---nl     8nl",
                division.divide("12345", "13"));
    }

    @Test
    void divide_shouldReturnSolutionOnLongDividionwithoutCalculator_whenInputStringContainsMaxLongValues_9223372036854775807_9223372036854775807()
            throws DividendIsLessThanDivisorException {
        assertEquals("_9223372036854775807nl 9223372036854775807nl -------------------nl                   0nl",
                division.divide("9223372036854775807", "9223372036854775807"));
    }

    @Test
    void divide_shouldGetIllegalArgumentException_whenInputStringContainsDivisorAsNull()
            throws DividendIsLessThanDivisorException {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            division.divide("10", null);
        });
        assertEquals("null", exception.getMessage());
    }

    @Test
    void divide_shouldGetIllegalArgumentException_whenInputStringContainsDividendAsNull()
            throws DividendIsLessThanDivisorException {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            division.divide(null, "10");
        });
        assertEquals("null", exception.getMessage());
    }

    @Test
    void divide_shouldGetIllegalArgumentException_whenInputStringContainDividendEqualToZero() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            division.divide("10", "0");
        });
        assertEquals("Divisor cannot be 0, division by zero. Your solution: Undefined", exception.getMessage());
    }
}
