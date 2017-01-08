package com.vis.arun.calculator.api;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vasudvis on 12/24/2016.
 */
public class OperationHandlerImplTest {
    OperationHandler operationHandler = new OperationHandlerImpl();
    @Test
    public void additionTest1() throws Exception {
        Assert.assertEquals(this.operationHandler.perform(getBdList("1","2"), getOperatorList(Operator.ADDITION)), new BigDecimal("3"));
    }

    @Test
    public void additionTest2() throws Exception {
        Assert.assertEquals(this.operationHandler.perform(getBdList("1","2", "3"), getOperatorList(Operator.ADDITION, Operator.ADDITION)), new BigDecimal("6"));
    }


    @Test
    public void divisionTest1() throws Exception {
        Assert.assertEquals(this.operationHandler.perform(getBdList("4","2"), getOperatorList(Operator.DIVISION)), new BigDecimal("2"));
    }

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(this.operationHandler.perform(getBdList("4","2", "3"), getOperatorList(Operator.ADDITION,Operator.MULTIPLICATION)), new BigDecimal("10"));
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(this.operationHandler.perform(getBdList("4.2","2.1", "3.3"), getOperatorList(Operator.ADDITION,Operator.MULTIPLICATION)), new BigDecimal("11.129999999999999"));
    }



    public List<BigDecimal> getBdList(String... numbers){
        List<BigDecimal> decimalList = new ArrayList<BigDecimal>();
        for(String num: numbers){
            decimalList.add(new BigDecimal(num));
        }
        return decimalList;
    }

    public List<Operator> getOperatorList(Operator... ops){
        List<Operator> opList = new ArrayList<Operator>();
        for(Operator op: ops){
            opList.add(op);
        }
        return opList;
    }

    /**
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
        Assert.assertEquals(this.operationHandler.perform("0.211","2.2", Operator.ADDITION), "2.411");
    }

    public void subtractionTest1() throws Exception {
        Assert.assertEquals("-2", this.operationHandler.perform("0.2","2.2", Operator.SUBSTRACTION));
    }

    @Test
    public void subtractionTest2() throws Exception {
        Assert.assertEquals("0.999", this.operationHandler.perform("1",".001", Operator.SUBSTRACTION));
    } **/
}