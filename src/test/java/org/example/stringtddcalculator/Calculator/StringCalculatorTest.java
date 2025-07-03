package org.example.stringtddcalculator.Calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void shouldReturnZeroForEmptyString() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
    }
    @Test
    void shouldReturnNumberWhenOnlyOneNumberGiven(){
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1"));
    }
}
