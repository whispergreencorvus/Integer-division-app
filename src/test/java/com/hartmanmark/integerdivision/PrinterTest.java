package com.hartmanmark.integerdivision;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class PrinterTest {
   
    @Test
    void divide_shouldPrintSolutionOnLongDividionwithoutCalculator_whenInputStringContains_intermediateDivisionResult_quotien_dividend_divisor() {
        Printer print = new Printer();
        
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
                   + "",
                print.print("_123nl 117nl ---nl  _64nl   52nl   --nl  _125nl   117nl   ---nl     8nl", "949", "12345", "13"));
    }
}
