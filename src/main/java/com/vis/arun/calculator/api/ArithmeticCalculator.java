package com.vis.arun.calculator.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasudvis on 12/24/2016.
 */
public class ArithmeticCalculator implements Calculator {

    private BigDecimal acc;
    private List<BigDecimal> operadList;
    private List<Operator> operatorList;

    public ArithmeticCalculator(){
        reinit();
    }

    @Override
    public void reinit() {
        acc = new BigDecimal("0");
        this.operadList = new ArrayList<BigDecimal>();
        this.operatorList = new ArrayList<Operator>();
    }

    @Override
    public BigDecimal reinit(BigDecimal value) {
        this.reinit();
        this.addOperand(value);
        return value;
    }

    @Override
    public BigDecimal getAc() {
        return this.acc;
    }

    @Override
    public void addOperand(BigDecimal operand) {
        this.operadList.add(operand);
    }

    @Override
    public void setOperator(Operator operator) {
        this.operatorList.add(operator);
    }

    @Override
    public BigDecimal execute() {
        return null;
    }
}
