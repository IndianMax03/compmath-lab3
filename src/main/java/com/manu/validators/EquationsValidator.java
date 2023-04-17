package com.manu.validators;

import com.manu.functions.*;
import com.manu.functions.Module;
import com.manu.methods.*;
import com.manu.model.EquationData;

import java.util.HashMap;

public class EquationsValidator {

    private static final HashMap<String, Function> functions = new HashMap<>();
    private static final HashMap<String, EquationMethod> methods = new HashMap<>();

    static {
        functions.put("sincos", new SinCos());
        functions.put("epi", new Epi());
        functions.put("module", new Module());
        functions.put("hyper", new Hyper());
        functions.put("down", new Down());

        methods.put("LeftRectangle", new LeftRectangle());
        methods.put("MiddleRectangle", new MiddleRectangle());
        methods.put("RightRectangle", new RightRectangle());
        methods.put("Trapeze", new Trapeze());
        methods.put("Simpson", new Simpson());
    }

    public static boolean validateData(EquationData data) {
        try {
            double a = Double.parseDouble(data.getA().replaceAll(",", "."));
            double b = Double.parseDouble(data.getB().replaceAll(",", "."));
            double eps = Double.parseDouble(data.getEps().replaceAll(",", "."));
            if (!(a < b) || eps < 0 || !(functions.containsKey(data.getEquation()) || !(methods.containsKey(data.getMethod())))) {
                return false;
            }

        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static boolean formatData(EquationData data) {
        double a = data.getValidA();
        double b = data.getValidB();
        switch (data.getEquation()) {
            case "hyper":
                if (a == Hyper.BREAKING_POINT || b == Hyper.BREAKING_POINT) {
                    return false;
                }
                if (a > Hyper.BREAKING_POINT || b < Hyper.BREAKING_POINT) {
                    return true;
                }
                if (Math.abs(b) >= Math.abs(a)) {
                    data.setValidA(-a);
                } else {
                    data.setValidB(-b);
                }
                break;
            case "down":
                if (a == Down.BREAKING_POINT || b == Down.BREAKING_POINT) {
                    return false;
                }
                return a > Down.BREAKING_POINT || b < Down.BREAKING_POINT;
            default:
                break;
        }
        return true;
    }

    public static Function getFunction(String functionName) {
        return functions.get(functionName);
    }

    public static EquationMethod getMethod(String methodName) {
        return methods.get(methodName);
    }

}
