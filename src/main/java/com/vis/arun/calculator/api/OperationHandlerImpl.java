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
    }

    public String perform(String op1, String op2, Operator operator) {
        BigDecimal num1 = new BigDecimal(op1);
        BigDecimal num2 = new BigDecimal(op2);
        switch (operator){
            case ADDITION : return addition(num1, num2);
            case SUBSTRACTION : return subtraction(num1, num2);
            case MULTIPLICATION : return multiplication(num1, num2);
            case DIVISION : return division(num1, num2);
            default: return "";
        }
    }


    public String addition(BigDecimal num1, BigDecimal num2){
        return String.valueOf(num1.add(num2));
    }

    public String subtraction(BigDecimal num1, BigDecimal num2){
        return String.valueOf(num1.subtract(num2));
    }

    public String multiplication(BigDecimal num1, BigDecimal num2){
        return String.valueOf(num1.multiply(num2));
    }

    public String division(BigDecimal num1, BigDecimal num2){
        return String.valueOf(num1.divide(num2));
    }
}
