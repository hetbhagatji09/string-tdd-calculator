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
    @Test
    void shouldReturnNumberWhenOnlyTwoNumbersGiven(){
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("1,2"));
    }
    @Test
    void shouldReturnSumWhenMultipleNumbersAreGiven(){
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1,2,3"));
    }
    @Test
    void shouldHandleNewLineAsDelimiterAlongWithComma() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }
}
