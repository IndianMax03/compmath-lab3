package com.manu.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.model.EquationData;
import com.manu.validators.EquationsValidator;

public class EquationService {

    public ObjectNode analyze(EquationData data) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        if (!EquationsValidator.validateData(data) || !data.setValidData()) {
            node.put("error", "got invalid data");
            return node;
        }

        if (!EquationsValidator.formatData(data)) {
            node.put("error", "The integral does not exist");
            return node;
        }

        return data.solveEquation();
    }

}
