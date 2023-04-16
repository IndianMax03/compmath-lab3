package com.manu.validators;

import com.manu.functions.Epi;
import com.manu.functions.Function;
import com.manu.functions.Module;
import com.manu.functions.SinCos;
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

    public static Function getFunction(String functionName) {
        return functions.get(functionName);
    }

    public static EquationMethod getMethod(String methodName) {
        return methods.get(methodName);
    }

}
