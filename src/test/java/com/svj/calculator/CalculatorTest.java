package com.svj.calculator;

import com.svj.Calculator.Calculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calc= new Calculator();

    // BeforeEach is useful when getting a new instance before each test
//    @BeforeEach
//    void setUp() {
//        calc = new Calculator();
//    }

    @Test
    public void canAddZeroPlusZero(){
        int sum= calc.add(0, 0);
        assertEquals(0, sum, "Was expecting sum of 0"); // arg 3 is used to mention a message upon failure of an assert. This is useful when we have multiple asserts in a test method
    }

    @Test
    public void canAddOnePlusOne(){
        int sum= calc.add(1, 1);
        assertEquals(2, sum);
    }

    @Test
    public void canAddOppSignedNums(){
        int sum= calc.add(10, -3);
        assertEquals(7, sum);
    }

    @Test
    @Disabled
    public void canAddMaxIntPlusOne(){
        int sum= calc.add(Integer.MAX_VALUE, 1);
        System.out.println(sum); // 2147483647
        assertEquals(Integer.MAX_VALUE+1L, sum);
    }

    @Test
    public void annuityExample(){
        String answer= calc.calcAnnuity("22000",7, "6%", 1);
        assertEquals("$184,664.43", answer);
    }

    @Test
    public void annuityPractice2() {
        String answer= calc.calcAnnuity("1200",10, "8%", 4);
        assertEquals("$72,482.38", answer);
    }
}
