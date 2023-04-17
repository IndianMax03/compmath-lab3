package com.manu.functions;

public class Down extends Function {

    public static final double BREAKING_POINT = 2d;

    @Override
    public double func(double x) {
        return 1/(-x*x + 4*x - 4);
    }
}
