package com.manu.model;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.Function;
import com.manu.methods.EquationMethod;
import com.manu.validators.EquationsValidator;

public class EquationData {

    String a;
    String b;
    String eps;
    String equation;
    String method;

    private double validA;

    private double validB;

    private double validEps;

    private Function function;

    private EquationMethod equationMethod;

    public EquationData() {
    }

    public EquationData(String a, String b, String eps, String equation, String method) {
        this.a = a;
        this.b = b;
        this.eps = eps;
        this.equation = equation;
        this.method = method;
    }

    public boolean setValidData() {
        try {
            this.validA = Double.parseDouble(this.a.replaceAll(",", "."));
            this.validB = Double.parseDouble(this.b.replaceAll(",", "."));
            this.validEps = Double.parseDouble(this.eps.replaceAll(",", "."));
            this.function = EquationsValidator.getFunction(this.equation);
            this.equationMethod = EquationsValidator.getMethod(this.method);

            if (this.function == null || this.equationMethod == null) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException exception) {
            return false;
        }

        return true;
    }

    public ObjectNode solveEquation() {
        return equationMethod.solve(this.validA, this.validB, this.validEps, this.function);
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "EquationData{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", eps='" + eps + '\'' +
                ", equation='" + equation + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
