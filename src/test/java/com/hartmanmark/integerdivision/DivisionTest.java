package com.hartmanmark.integerdivision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionTest {

    private Division division;

    @BeforeEach
    void init() {
        division = new Division();
    }

    @Test
    void divide_shouldReturnSolutionOnLongDividionwithoutCalculator_whenInputStringContains_1357_4() {
        assertEquals("_1357│4\n"
                + " 12  │---\n"
                + " --  │339\n"
                + " _15\n"
                + "  12\n"
                + "  --\n"
                + "  _37\n"
                + "   36\n"
                + "   --\n"
                + "    1\n"
                + "", division.divide("1357", "4"));
    }

    @Test
    void divide_shouldReturnSimpleSolutionContainOneStringWithAnswerZero_whenInputStringContainDivisorIsGreaterThanDividend() {
        assertEquals("10 / 11 = 0", division.divide("10", "11"));
    }

    @Test
    void divide_shouldReturnSimpleSolutionContainOneStringWithAnswerZero_whenInputStringContainDividendEqualToZero() {
        assertEquals("0 / 10 = 0", division.divide("0", "10"));
    }

    @Test
    void divide_shouldReturnSolutionOnLongDividionwithoutCalculator_whenInputStringContainsMaxLongValues_150_3() {
        assertEquals("_9223372036854775807│9223372036854775807\n"
                + " 9223372036854775807│-\n"
                + " -------------------│1\n"
                + "                   0\n"
                + "", division.divide("9223372036854775807", "9223372036854775807"));
    }

    @Test
    void divide_houldGetIllegalArgumentException_whenInputStringContainDividendEqualToZero() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            division.divide("10", "0");
        });
        assertEquals("Divisor cannot be 0, division by zero. Your solution: Undefined", exception.getMessage());
    }
}
