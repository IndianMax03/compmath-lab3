package com.manu.functions;

public class Module extends Function {

    @Override
    public double func(double x) {
        return Math.abs(Math.pow(x, 5) / 3) - 2 * x * x - Math.abs(2 * x);
    }

}
