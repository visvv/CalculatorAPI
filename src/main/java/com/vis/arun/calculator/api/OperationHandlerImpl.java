package com.vis.arun.calculator.api;

import javafx.util.converter.BigDecimalStringConverter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * Created by vasudvis on 12/24/2016.
 */
public class OperationHandlerImpl implements OperationHandler {
    private ScriptEngine engine;

    public OperationHandlerImpl() {
        initScriptEngine();
    }

    private void initScriptEngine() {
        ScriptEngineManager mgr = new ScriptEngineManager();
        engine = mgr.getEngineByName("JavaScript");
    }

    public String perform(String op1, String op2, Operator operator) {
        int scale = Math.max(getDecimalCount(op1), getDecimalCount(op2));
        try {
            String result =  engine.eval(op1 + operator.getSign() + op2).toString();
            return format(result, scale);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String format(String result, int scale){
        BigDecimal bd = new BigDecimal(result);
        bd = bd.setScale(scale, RoundingMode.HALF_UP);
        return bd.toString();
    }

    private int getDecimalCount(String number){
        return number.length() - number.lastIndexOf('.');
    }


}
