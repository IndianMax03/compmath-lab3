package com.manu.functions;

public class Epi extends Function {

    private final double CONSTANT = (Math.pow(Math.E, Math.PI) - 100 * Math.PI) / (300);

    @Override
    public double func(double x) {
        return Math.pow(Math.PI, Math.sin(-x * Math.cos(x))) + CONSTANT;
    }

}
