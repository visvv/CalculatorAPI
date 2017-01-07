package com.vis.arun.calculator.api;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

/**
 * Created by vasudvis on 12/24/2016.
 */
public class OperationHandlerImplTest {
    OperationHandler operationHandler = new OperationHandlerImpl();
    @Test
    public void additionTest1() throws Exception {
        Assert.assertEquals(this.operationHandler.perform("1","2", Operator.ADDITION), "3");
    }

    @Test
    public void additionTest2() throws Exception {
        Assert.assertEquals(this.operationHandler.perform("0","2", Operator.ADDITION), "2");
    }

    @Test
    public void additionTest3() throws Exception {
        Assert.assertEquals(this.operationHandler.perform("0","2.2", Operator.ADDITION), "2.2");
    }
    @Test
    public void additionTest4() throws Exception {
        Assert.assertEquals(this.operationHandler.perform("0.2","2.2", Operator.ADDITION), "2.4");
    }

    @Test
    public void additionTest5() throws Exception {
        String number = "234.45";
        System.out.print(number.length() - number.lastIndexOf('.'));
       // Assert.assertEquals(Math., "2.4");
    }


    public String addition(String op1, String op2, Operator op){
        
    }

}