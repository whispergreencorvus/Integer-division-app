package com.hartmanmark.integerdivision;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hartmanmark.inteherdivision.exception.DividendIsLessThanDivisorException;
import com.hartmanmark.inteherdivision.exception.DivisorIsZeroException;

class PrinterTest {

    private Printer print;

    @BeforeEach
    void init() {
        print = new Printer();
    }

    @Test
    void print_shouldPrintSolutionOnLongDividionwithoutCalculator_whenInputStringContains_12345_13()
            throws DividendIsLessThanDivisorException, DivisorIsZeroException {
        assertEquals("_12345│13\n"
                + " 117  │---\n"
                + " ---  │949\n"
                + "  _64\n"
                + "   52\n"
                + "   --\n"
                + "  _125\n"
                + "   117\n"
                + "   ---\n"
                + "     8\n"
                + "", print.print("12345", "13"));
    }

    @Test
    void print_shouldPrintSolutionOnLongDividionwithoutCalculator_whenInputStringContains_123456789_3()
            throws DividendIsLessThanDivisorException, DivisorIsZeroException {
        assertEquals("_123456789│3\n"
                + " 12       │--------\n"
                + " --       │41152263\n"
                + "  _3\n"
                + "   3\n"
                + "   -\n"
                + "   _4\n"
                + "    3\n"
                + "    -\n"
                + "   _15\n"
                + "    15\n"
                + "    --\n"
                + "     _6\n"
                + "      6\n"
                + "      -\n"
                + "      _7\n"
                + "       6\n"
                + "       -\n"
                + "      _18\n"
                + "       18\n"
                + "       --\n"
                + "        _9\n"
                + "         9\n"
                + "         -\n"
                + "         0\n"
                + "", print.print("123456789", "3"));
    }

    @Test
    void print_shouldPrintSolutionOnLongDividionwithoutCalculator_whenInputStringContains_100000000000_333()
            throws DividendIsLessThanDivisorException, DivisorIsZeroException {
        assertEquals("_100000000000│333\n"
                + "  999        │---------\n"
                + "  ---        │300300300\n"
                + "   _1000\n"
                + "     999\n"
                + "     ---\n"
                + "      _1000\n"
                + "        999\n"
                + "        ---\n"
                + "          100\n"
                + "", print.print("100000000000", "333"));
    }

    @Test
    void print_shouldPrintSolutionOnLongDividionwithoutCalculator_whenInputStringContains_9223372036854775807_9223372036854775806()
            throws DividendIsLessThanDivisorException, DivisorIsZeroException {
        assertEquals("_9223372036854775807│9223372036854775806\n"
                + " 9223372036854775806│-\n"
                + " -------------------│1\n"
                + "                   1\n"
                + "", print.print("9223372036854775807", "9223372036854775806"));
    }
}
