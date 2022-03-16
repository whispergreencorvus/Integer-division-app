package com.hartmanmark.integerdivision;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hartmanmark.inteherdivision.exception.DividendIsLessThanDivisorException;
import com.hartmanmark.inteherdivision.exception.DivisorIsZeroException;

class DivisionServiceTest {

    private DivisionService division;

    @BeforeEach
    void init() {
        division = new DivisionService();
    }

    @Test
    void divide_shouldReturnSolutionOnLongDividionwithoutCalculator_whenInputStringContains_12345_13()
            throws DividendIsLessThanDivisorException, DivisorIsZeroException {
        assertEquals("_123nl 117nl ---nl  _64nl   52nl   --nl  _125nl   117nl   ---nl     8nl",
                division.divide("12345", "13"));
    }

    @Test
    void divide_shouldReturnSolutionOnLongDividionwithoutCalculator_whenInputStringContainsMaxLongValues_9223372036854775807_9223372036854775807()
            throws DividendIsLessThanDivisorException, DivisorIsZeroException {
        assertEquals("_9223372036854775807nl 9223372036854775807nl -------------------nl                   0nl",
                division.divide("9223372036854775807", "9223372036854775807"));
    }

    @Test
    void divide_shouldPrintSolutionOnLongDividionwithoutCalculator_whenInputStringContains_123456789_3()
            throws DividendIsLessThanDivisorException, DivisorIsZeroException {
        assertEquals(
                "_12nl 12nl --nl  _3nl   3nl   -nl  "
                + " _4nl    3nl    -nl   _15nl    15nl  "
                + "  --nl     _6nl      6nl      -nl     "
                + " _7nl       6nl       -nl      _18nl     "
                + "  18nl       --nl        _9nl         9nl    "
                + "     -nl         0nl",
                division.divide("123456789", "3"));
    }
}
