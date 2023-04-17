package com.manu.methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MiddleRectangle extends EquationMethod {
    @Override
    public ObjectNode solve(double a, double b, double eps, Function function) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        ArrayList<Long> nList = getNList();
        ArrayList<Double> integralList = getIntegralList();
        ArrayList<Double> epsList = getEpsList();

        double prevIntegralValue;
        double curIntegralValue = 0;
        int iteration = 0;
        long n = N;

        do {
            prevIntegralValue = curIntegralValue;
            curIntegralValue = 0;

            double step = (b - a) / n;

            for (int i = 1; i <= n; i++) {
                curIntegralValue += function.func(( (a + step * i) + (a + step * (i-1)) ) / 2) * step;
            }
            nList.add(n);
            integralList.add(curIntegralValue);
            epsList.add(Math.abs(curIntegralValue - prevIntegralValue)/3);
            n = n * 2;
            iteration++;
        } while (Math.abs(curIntegralValue - prevIntegralValue)/3  > eps && iteration != MAX_ITERATION);

        if (iteration != MAX_ITERATION) {
            node.put("success", "true");
        } else {
            node.put("success", "false");
        }

        node.putPOJO("n", nList);
        node.putPOJO("I", integralList);
        node.putPOJO("eps", epsList);

        return node;
    }
}
