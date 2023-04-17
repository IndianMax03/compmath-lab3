package com.manu.functions;

public class SinCos extends Function {

    @Override
    public double func(double x) {
        return Math.sin(Math.cos(Math.sin(x)));
    }

}
