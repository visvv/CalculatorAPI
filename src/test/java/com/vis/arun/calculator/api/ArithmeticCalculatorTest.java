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
    public void testAddition(){
        calculator.reinit("2");
        calculator.execute(Operator.ADDITION);
        calculator.execute(Operator.ADDITION, "5");
        org.junit.Assert.assertEquals(calculator.getAc(), "7");
    }

}