package com.vis.arun.calculator.api;

import java.math.BigDecimal;

/**
 * Created by vasudvis on 12/24/2016.
 */
public interface Calculator {
    public void reinit();
    public BigDecimal reinit(BigDecimal value);
    public BigDecimal getAc();
    public void addOperand(BigDecimal operand);
    public void setOperator(Operator operator);
    public BigDecimal execute();
}
