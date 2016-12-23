package com.vis.arun.calculator.api;

/**
 * Created by vasudvis on 12/24/2016.
 */
public class ArithmeticCalculator implements Calculator {
    private String ac;
    private String opAc;
    private OperationHandler operationHandler;
    private Operator operator;

    public ArithmeticCalculator() {
        operationHandler = new OperationHandlerImpl();
        this.ac = "0";
        this.opAc = "";
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
    public String getAc() {
        return this.ac;
    }

    @Override
    public String addOperand(String operand) {
        opAc = opAc.concat(operand);
        return opAc;
    }

    @Override
    public void setOperator(Operator operator) {
        this.operator = operator;
        this.ac = this.opAc;
        this.opAc ="";
    }

    @Override
    public String execute() {
        if(this.operator == null){
            this.ac = this.opAc;
            this.opAc = null;
            return this.ac;
        }

        this.ac = operationHandler.perform(ac, opAc, operator);
        this.opAc = "";
        return this.ac;
    }
}
