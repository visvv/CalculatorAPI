package com.vis.arun.calculator.api;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by vasudvis on 12/24/2016.
 */
public interface OperationHandler {
    public BigDecimal perform(List<BigDecimal> operandList, List<Operator> operatorList);
}
