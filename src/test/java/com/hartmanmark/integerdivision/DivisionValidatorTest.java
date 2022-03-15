package com.hartmanmark.integerdivision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hartmanmark.inteherdivision.exception.DividendIsLessThanDivisorException;
import com.hartmanmark.inteherdivision.exception.DivisorIsZeroException;

class DivisionValidatorTest {

    private DivisionValidator divisionValidator;

    @BeforeEach
    void init() {
        divisionValidator = new DivisionValidator();
    }

  @Test
  void divisionValidator_shouldDivisorIsZeroException_whenInputStringContainDividendEqualToZero() {
      Throwable exception = assertThrows(DivisorIsZeroException.class, () -> {
          divisionValidator.verify("10", "0");
      });
      assertEquals("Divisor cannot be 0, division by zero.\n" + "Your solution: Undefined", exception.getMessage());
  }

  @Test
  void divisionValidator_shouldGetNumberFormatException_whenInputStringContainsDividendAsNull()
          throws DividendIsLessThanDivisorException {
      Throwable exception = assertThrows(NumberFormatException.class, () -> {
          divisionValidator.verify(null, "10");
      });
      assertEquals("null", exception.getMessage());
  }

  @Test
  void divisionValidator_shouldGetNumberFormatException_whenInputStringContainsDivisorAsNull()
          throws DividendIsLessThanDivisorException {
      Throwable exception = assertThrows(NumberFormatException.class, () -> {
          divisionValidator.verify("10", null);
      });
      assertEquals("null", exception.getMessage());
  }

}
