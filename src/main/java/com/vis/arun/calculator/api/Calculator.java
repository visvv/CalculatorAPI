package com.vis.arun.calculator.api;

/**
 * Created by vasudvis on 12/24/2016.
 */
public interface Calculator {
    public void reinit();
    public String reinit(String value);
    public String execute(Operator operator, String value);
    public String execute(Operator operator);
    public String execute(String value);
    public String getAc();
}
