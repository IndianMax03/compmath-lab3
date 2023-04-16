package com.manu.methods;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.Function;

public abstract class EquationMethod {

    private int n = 4;

    public abstract ObjectNode solve(double a, double b, double eps, Function function);

    protected int getN() {
        return this.n;
    }

    protected void incN() {
        this.n *= 2;
    }

}
