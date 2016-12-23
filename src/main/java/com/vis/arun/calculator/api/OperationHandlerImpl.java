package com.vis.arun.calculator.api;

import javafx.util.converter.BigDecimalStringConverter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * Created by vasudvis on 12/24/2016.
 */
public class OperationHandlerImpl implements OperationHandler {

    private Map<Operator, BinaryOperator<String>> operatorMap = new HashMap<>();

    public OperationHandlerImpl(){
        registerOperations();
    }

    private void registerOperations() {
          operatorMap.put(Operator.ADDITION, this::addition);
          operatorMap.put(Operator.SUBSTRACTION, this::subtraction);
          operatorMap.put(Operator.MULTIPLICATION, this::multiplication);
          operatorMap.put(Operator.DIVISION, this::division);
    }

    public String perform(String op1, String op2, Operator operator) {
        BinaryOperator<String> operation = operatorMap.get(operator);
        if(operation == null){
             throw new IllegalArgumentException("Non-Supported operation");
        }
        return operation.apply(op1, op2);
    }


    public String addition(String op1, String op2){
        BigDecimal int1 = new BigDecimal(op1);
        BigDecimal int2 = new BigDecimal(op2);
        return String.valueOf(int1.add(int2));
    }

    public String subtraction(String op1, String op2){
        BigDecimal int1 = new BigDecimal(op1);
        BigDecimal int2 = new BigDecimal(op2);
        return String.valueOf(int1.subtract(int2));
    }

    public String multiplication(String op1, String op2){
        BigDecimal int1 = new BigDecimal(op1);
        BigDecimal int2 = new BigDecimal(op2);
        return String.valueOf(int1.multiply(int2));
    }

    public String division(String op1, String op2){
        BigDecimal int1 = new BigDecimal(op1);
        BigDecimal int2 = new BigDecimal(op2);
        return String.valueOf(int1.divide(int2));
    }
}
