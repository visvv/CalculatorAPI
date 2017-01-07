package com.vis.arun.calculator.api;

/**
 * Created by vasudvis on 12/24/2016.
 */
public enum Operator {
    ADDITION(" + "),
    SUBSTRACTION(" - "),
    MULTIPLICATION(" * "),
    DIVISION("/");

    private String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }
}
