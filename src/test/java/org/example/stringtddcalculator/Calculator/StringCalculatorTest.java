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
    @Test
    void shouldSupportCustomDelimiterSpecifiedInPrefix() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }
    @Test
    void shouldThrowExceptionWhenNegativeNumberIsGiven(){
        StringCalculator calc = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("1,-2,3,-5");
        });

        assertEquals("negative numbers not allowed: -2,-5", exception.getMessage());

    }
    @Test
    void shouldTrackNumberOfTimesAddMethodIsCalled() {
        StringCalculator calc = new StringCalculator();
        calc.add("1,2");
        calc.add("3");
        assertEquals(2, calc.getCalledCount());
    }
    @Test
    void shouldIgnoreNumbersGreaterThan1000() {
        StringCalculator calc = new StringCalculator();
        assertEquals(2, calc.add("2,1001"));
    }
    @Test
    void shouldSupportDelimiterOfAnyLength() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("//[***]\n1***2***3"));
    }
    @Test
    void shouldSupportMultipleDelimitersOfAnyLength() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("//[**][%%]\n1**2%%3"));
    }
    

}
