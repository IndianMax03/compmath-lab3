package com.manu.methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.Function;

public class RightRectangle extends EquationMethod {
    @Override
    public ObjectNode solve(double a, double b, double eps, Function function) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("result", "rr is ok!");

        return node;
    }
}
