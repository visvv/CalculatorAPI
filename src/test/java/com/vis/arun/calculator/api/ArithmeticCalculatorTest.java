package com.vis.arun.calculator.api;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vasudvis on 12/24/2016.
 */
public class ArithmeticCalculatorTest {
    private Calculator calculator = new ArithmeticCalculator();

    @Test
    public void testAddition1(){
        calculator.addOperand("2");
        calculator.setOperator(Operator.ADDITION);
        calculator.addOperand("5");
        calculator.execute();
        org.junit.Assert.assertEquals(calculator.getAc(), "7");
    }

    // 2 + 3 + 4 + 5

    @Test
    public void testAddition2(){
        calculator.addOperand("2");
        calculator.addOperand("2");
        calculator.setOperator(Operator.ADDITION);
        calculator.addOperand("5");
        calculator.addOperand("5");
        org.junit.Assert.assertEquals(calculator.execute(), "77");
    }

}