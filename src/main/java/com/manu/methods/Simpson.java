package com.manu.methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.Function;

import java.util.ArrayList;

public class Simpson extends EquationMethod {
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

            for (int i = 0; i <= n; i++) {
                if (i == 0 || i == n) {
                    curIntegralValue += function.func(a + step * i);
                } else if (i % 2 == 0) {
                    curIntegralValue += 2 * function.func(a + step * i);
                } else {
                    curIntegralValue += 4 * function.func(a + step * i);
                }

            }
            curIntegralValue = step / 3 * curIntegralValue;
            nList.add(n);
            integralList.add(curIntegralValue);
            epsList.add(Math.abs(curIntegralValue - prevIntegralValue) / 3);
            n = n * 2;
            iteration++;
        } while (Math.abs(curIntegralValue - prevIntegralValue) / 15 > eps && iteration != MAX_ITERATION);

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
