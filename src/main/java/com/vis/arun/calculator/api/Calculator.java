package com.vis.arun.calculator.api;

/**
 * Created by vasudvis on 12/24/2016.
 */
public interface Calculator {
    public void reinit();
    public String reinit(String value);
    public String getAc();

    public String addOperand(String operand);
    public void setOperator(Operator operator);
    public String execute();
}
