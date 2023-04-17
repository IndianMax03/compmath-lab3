package com.manu.methods;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.Function;

import java.util.ArrayList;

public abstract class EquationMethod {

    protected final long N = 4;
    protected final int MAX_ITERATION = 20;
    private final ArrayList<Long> nList = new ArrayList<>();
    private final ArrayList<Double> integralList = new ArrayList<>();
    private final ArrayList<Double> epsList = new ArrayList<>();

    public abstract ObjectNode solve(double a, double b, double eps, Function function);

    protected ArrayList<Long> getNList() {
        this.nList.clear();
        return nList;
    }

    protected ArrayList<Double> getIntegralList() {
        this.integralList.clear();
        return integralList;
    }

    protected ArrayList<Double> getEpsList() {
        this.epsList.clear();
        return epsList;
    }

}
