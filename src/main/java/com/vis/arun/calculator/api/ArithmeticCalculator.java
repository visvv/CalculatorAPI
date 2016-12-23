package com.vis.arun.calculator.api;

/**
 * Created by vasudvis on 12/24/2016.
 */
public class ArithmeticCalculator implements Calculator {
    private String ac;
    private OperationHandler operationHandler;
    private Operator operator;

    public ArithmeticCalculator() {
        operationHandler = new OperationHandlerImpl();
    }

    @Override
    public void reinit() {
          ac = "0";
    }

    @Override
    public String reinit(String value) {
        ac = value;
        return ac;
    }

    @Override
    public String execute(Operator operator, String value) {
        ac = operationHandler.perform(ac, value, operator);
        return ac;
    }

    @Override
    public String getAc() {
        return this.ac;
    }

    @Override
    public String execute(Operator operator) {
        this.operator = operator;
        return  ac;
    }

    @Override
    public String execute(String value) {
        if(this.operator == null) return this.ac;
        return this.execute(this.operator, value);
    }
}
