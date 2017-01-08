package com.vis.arun.calculator.api;

import javafx.util.converter.BigDecimalStringConverter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * Created by vasudvis on 12/24/2016.
 */
public class OperationHandlerImpl implements OperationHandler {

    private Map<Operator, BinaryOperator<String>> operatorMap = new HashMap<>();
    private ScriptEngine engine;

    public OperationHandlerImpl(){
        initScriptEngine();
    }

    private BigDecimal perform(BigDecimal num1, BigDecimal num2, Operator operator) {
        switch (operator){
            case ADDITION : return addition(num1, num2);
            case SUBSTRACTION : return subtraction(num1, num2);
            case MULTIPLICATION : return multiplication(num1, num2);
            case DIVISION : return division(num1, num2);
            default: return new BigDecimal("0");
        }
    }

    private BigDecimal performExpression(List<BigDecimal> operandList, List<Operator> operatorList){
        StringBuilder builder = new StringBuilder();
        int counter=0;
        for (BigDecimal num: operandList) {
            builder.append(num);
            if(counter < (operandList.size() -1)) {
                builder.append(operatorList.get(counter).getSign());
                counter++;
            }
        }
        String evalResult = "0";
        try {
            System.out.println(builder.toString());
            evalResult = engine.eval(builder.toString()).toString();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return new BigDecimal(evalResult);
    }

    @Override
    public BigDecimal perform(List<BigDecimal> operandList, List<Operator> operatorList) {
        if(operandList.size() == 2 && operatorList.size() == 1){
            return perform(operandList.get(0), operandList.get(1), operatorList.get(0));
        }else if(operandList.size() > 2 && operatorList.size() == operandList.size() -1){
            return performExpression(operandList, operatorList);
        }
        return null;
    }

    private void initScriptEngine() {
        ScriptEngineManager mgr = new ScriptEngineManager();
        engine = mgr.getEngineByName("JavaScript");
    }

    public BigDecimal addition(BigDecimal num1, BigDecimal num2){
        return num1.add(num2);
    }

    public BigDecimal subtraction(BigDecimal num1, BigDecimal num2){
        return num1.subtract(num2);
    }

    public BigDecimal multiplication(BigDecimal num1, BigDecimal num2){
        return num1.multiply(num2);
    }

    public BigDecimal division(BigDecimal num1, BigDecimal num2){
        return num1.divide(num2);
    }
}
